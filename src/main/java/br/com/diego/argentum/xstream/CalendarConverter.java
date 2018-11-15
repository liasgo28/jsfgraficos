/*
 * ====================================================================
 * Direitos de cópia pela BRASILPREV
 * 
 * Todos os direitos reservados.
 * 
 * Este sistema contém informações confidenciais e de propriedade da
 * BRASILPREV ("Informações Confidenciais").
 * Você não deve divulgar tais informações confidenciais e deve
 * usá-las somente em conformidade com os termos do contrato de licença
 * definidos pela BRASILPREV.
 * ==================================================================== 
 */
package br.com.diego.argentum.xstream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class CalendarConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.isAssignableFrom(GregorianCalendar.class);
    }

    @Override
    public void marshal(Object calendar, HierarchicalStreamWriter writer, MarshallingContext context) {
        GregorianCalendar data = (GregorianCalendar) calendar;
        data.getTime();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        writer.startNode("time");
        writer.setValue(format.format(data.getTime()));
        writer.endNode();

        writer.startNode("timezone");
        writer.setValue(data.getTimeZone().getID());
        writer.endNode();

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        reader.moveDown();
        String time = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        String timezone = reader.getValue();
        reader.moveUp();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        TimeZone teste = TimeZone.getTimeZone(timezone);
        GregorianCalendar calendar = new GregorianCalendar(teste);
        Date date;
        try {
            date = format.parse(time);
            calendar.setTime(date);
            calendar.setTimeZone(teste);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calendar;
    }

}
