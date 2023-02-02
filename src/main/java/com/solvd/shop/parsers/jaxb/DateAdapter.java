package com.solvd.shop.parsers.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter <String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(Date date) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(date);
        }
    }

    @Override
    public Date unmarshal(String string) throws Exception {
        synchronized (dateFormat) {
            return (Date) dateFormat.parse(string);
        }
    }

}
