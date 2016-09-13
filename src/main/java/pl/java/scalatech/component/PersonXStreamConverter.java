package pl.java.scalatech.component;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import pl.java.scalatech.domain.Person;

public class PersonXStreamConverter implements Converter{

        @Override
        public boolean canConvert(Class type) {          
            return type == Person.class;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            Person customer = (Person) source;
            writer.setValue("My person is : " +customer.getAge() + " and his lastName is : " + customer.getName());
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return null;
        }
}