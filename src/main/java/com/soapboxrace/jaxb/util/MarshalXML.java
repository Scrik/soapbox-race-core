package com.soapboxrace.jaxb.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

public class MarshalXML {

	public static String marshal(JAXBElement<?> jaxbElement) {
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbElement.getValue().getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
			jaxbMarshaller.marshal(jaxbElement, stringWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringWriter.toString();
	}
}