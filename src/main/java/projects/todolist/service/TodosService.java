package projects.todolist.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import projects.todolist.config.DbUtil;
import projects.todolist.model.Task;
import projects.todolist.model.Todos;

import java.util.Collection;
import java.util.List;

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

    public Collection<Todos> findAll() {
        log.debug("Pobieranie list zadań");
        Session session = DbUtil.getSession();
        List<Todos> todos = session.createQuery("SELECT to FROM Todos to ORDER BY to.createdOn DESC", Todos.class).getResultList();
        log.debug("Pobrano {} list zadań", todos.size());
        return todos;
    }


    public Task getTask(Long id) {
        return null;
    }

    public Task getTask(Long todosId, String name) {
        return null;
    }

    public void delete(Task task) {
    }


}