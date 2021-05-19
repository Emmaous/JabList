/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import ejb.LogFacadeRemote;
import entities.LogsGroup7;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author phil
 */
@JMSDestinationDefinition(name = "java:app/LogQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "LogQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/LogQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class NewMessageBean implements MessageListener {
    
    @EJB
    private LogFacadeRemote logsFacade;

    public LogFacadeRemote getLogsFacade() {
        return logsFacade;
    }

    public void setLogsFacade(LogFacadeRemote logsFacade) {
        this.logsFacade = logsFacade;
    }
    
    public NewMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        LogsGroup7 newLog = null;
        newLog = (LogsGroup7)message;
        getLogsFacade().create(newLog);        
    }
    
}
