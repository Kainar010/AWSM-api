package me.kainar.awsm;

import jakarta.annotation.PostConstruct;
import me.kainar.awsm.model.listener.LikeEventListener;
import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventWiring {
    private final SessionFactory sessionFactory;

    private final LikeEventListener listener;

    @Autowired
    public HibernateEventWiring(SessionFactory sessionFactory, LikeEventListener listener){
        this.sessionFactory = sessionFactory;
        this.listener = listener;
    }

    @PostConstruct
    public void registerListener(){
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
                EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.POST_COMMIT_INSERT).appendListener(listener);
    }
}
