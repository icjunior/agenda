package br.com.bigsupermercados.tarefa;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Esta classe demonstra uma tarefa que ira ser invocada pelo Quartz Tem que
 * implementar a interface Job do Quartz
 * 
 * @author julianom
 */
public class TarefaExemplo implements Job {
	/**
	 * Metodo que é executado quando a tarefa é invocada
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// aqui vai a lógica da tarefa a ser chamada,
		// por exemplo, fazer um select no banco e enviar algum dado para uma
		// fila MQ
		// Neste exemplo, vai somente imprimir no console a data de hoje no
		// intervalo de 5 segundos
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy – hh:mm:ss");
		System.err.println("Rodou: " + dateFormat.format(new Date()));
	}
}