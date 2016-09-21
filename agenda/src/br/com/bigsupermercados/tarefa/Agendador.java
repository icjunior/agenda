package br.com.bigsupermercados.tarefa;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Esta é a classe que deve ser invocada e irá disparar a tarefa nos momentos
 * determinados
 *
 * @author julianom
 *
 */
public class Agendador {

	public static void inicia() throws Exception {
		// Detalhes da tarefa
		JobDetail job = JobBuilder.newJob(TarefaExemplo.class)
				.withIdentity("tarefaAloMundo", "group1").build();
		// Gatilho - ou seja, quando irá chamar, neste caso, a cada 5 segundos
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("gatilhoAloMundo", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
				.build();

		// Agenda e voa lá!
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}

}