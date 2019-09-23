package ru.job4j.sql;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

public class StoreXML {

    private final File target;

    public StoreXML(File target) {
        this.target = target;
    }

    public void save(List<Entry> list) {
        try {
            JAXBContext context = JAXBContext.newInstance(Entrys.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Entrys(list), this.target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @XmlRootElement
    public static class Entrys {
        private List<Entry> entry;

        public Entrys() {
        }

        public Entrys(List<Entry> entry) {
            this.entry = entry;
        }

        public List<Entry> getEntry() {
            return entry;
        }

        public void setEntry(List<Entry> entry) {
            this.entry = entry;
        }
    }
}
