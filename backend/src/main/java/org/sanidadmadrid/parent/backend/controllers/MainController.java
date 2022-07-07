package org.sanidadmadrid.parent.backend.controllers;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Creado por Lineu Martins el 06/07/2022 23:47
 */
@RestController
@RequestMapping(value = "/api")
@Slf4j
public class MainController {

	@CrossOrigin("http://localhost:4200")
	@GetMapping(value = "/pdf/{texto}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<ByteArrayResource> getPdf(@PathVariable String texto) throws IOException, JRException {

		Map<String, Object> params = new HashMap<>();
		params.put("texto", texto);

		JasperPrint pdf;

		try (InputStream in = getClass().getResourceAsStream("/example.jrxml")) {
			pdf = JasperFillManager.fillReport
					(
							JasperCompileManager.compileReport(in)
							, params
							, new JREmptyDataSource()
					);
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(pdf, outputStream);
		byte[] reportContent = outputStream.toByteArray();
		ByteArrayResource report = new ByteArrayResource(reportContent);
		return new ResponseEntity<>(report, HttpStatus.OK);
	}
}
