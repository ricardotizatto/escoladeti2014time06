package br.unicesumar.escoladeti.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.unicesumar.escoladeti.entity.Usuario;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "public/home";
	}

	@RequestMapping(value = { "/privatehome", "/" }, method = RequestMethod.GET)
	public String privateHome(Locale locale, Model model) {
		logger.info("PRIVATE home! The client locale is {}.", locale);
		return "private/index";
	}
	@RequestMapping(value = "/private/teste", method = RequestMethod.GET)
	public String privateTeste(Locale locale, Model model) {
		logger.info("PRIVATE TESTE! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "private/teste";
	}

	/*
	@RequestMapping(value = "private/usuarios", produces = "application/json", method = RequestMethod.GET)
	private @ResponseBody ResponseEntity<Usuario> usuario() {
		Usuario u = new Usuario();
		u.setId(100L);
		u.setLogin("root");
		u.setSenha("senhaboa");
		return new ResponseEntity<>(u, new HttpHeaders(), HttpStatus.OK);
	}*/

}
