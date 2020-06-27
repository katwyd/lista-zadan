package projects.todolist.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.todolist.config.DbUtil;
import projects.todolist.model.Todos;

public class TodosService {

    private static final Logger log = LoggerFactory.getLogger(TodosService.class);

    public void saveTodos(Todos todos) {
        log.debug("Zapisywanie listy zadań: {}", todos);
        Transaction transaction = null;
        try {
            Session session = DbUtil.getSession();
            transaction = session.beginTransaction();
            session.save(todos);
            log.info("Zapisano listę zadań: {}", todos);
            transaction.commit();
        } catch (Exception e) {
            log.error("Błąd zapisu listy zadań", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}