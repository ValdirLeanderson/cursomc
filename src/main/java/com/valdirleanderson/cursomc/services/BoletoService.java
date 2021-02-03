package com.valdirleanderson.cursomc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.valdirleanderson.cursomc.domain.PagamentoBoleto;

@Service
public class BoletoService {
	public void preencherPagamentoBoleto(PagamentoBoleto pgto, Date instante) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instante);
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		pgto.setDataVencimento(calendar.getTime());
	}
}
