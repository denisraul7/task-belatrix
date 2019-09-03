package com.belatrix.tech.task.data;

import com.belatrix.tech.task.data.creating.impl.CreateLogServiceImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CreateLogServiceImplTest{

  private CreateLogServiceImpl service;

  @Before
  private void init () {
        service = new CreateLogServiceImpl();
    }

  @Test
  public void createMessageLogTest(){

    boolean logError = false;
    boolean logWarning = false;
    boolean logMessage = false;

    String resultMessage = service.createMessageLog("test", logError, logWarning, logMessage);
    Assert.assertEquals(resultMessage, "");

  }

  @Test
  public void createMessageLogErrorTest(){

    String message = "Ocurrio un error en el registro del cliente.";
    boolean logError = true;
    boolean logWarning = false;
    boolean logMessage = false;

    String resultMessage = service.createMessageLog(message, logError, logWarning, logMessage);
    Assert.assertEquals(resultMessage, "error 2019-09-03 10:55:03 UTC Ocurrio un error en el registro del cliente.");

  }

  @Test
  public void createMessageLogWarningTest(){

    String message = "El nombre del cliente, debe tener al menos 3 caracteres.";
    boolean logError = false;
    boolean logWarning = true;
    boolean logMessage = false;

    String resultMessage = service.createMessageLog(message, logError, logWarning, logMessage);
    Assert.assertEquals(resultMessage, "warning 2019-09-03 10:55:27 UTC El nombre del cliente, debe tener al menos 3 caracteres.");

  }

  @Test
  public void createMessageLogMessageTest(){

    String message = "El cliente se registro con exito.";
    boolean logError = false;
    boolean logWarning = false;
    boolean logMessage = true;

    String resultMessage = service.createMessageLog(message, logError, logWarning, logMessage);
    Assert.assertEquals(resultMessage, "message 2019-09-03 10:55:31 UTC El cliente se registro con exito.");

  }

  @Test
  public void getSelectTypeLogTest(){
    boolean logError = false;
    boolean logWarning = false;
    boolean logMessage = false;

    int resultType = service.getSelectTypeLog(logError, logWarning, logMessage);
    Assert.assertEquals(resultType, 0);
  }

  @Test
  public void getSelectTypeLogErrorTest(){
    boolean logError = true;
    boolean logWarning = false;
    boolean logMessage = false;

    int resultType = service.getSelectTypeLog(logError, logWarning, logMessage);
    Assert.assertEquals(resultType, 2);
  }

  @Test
  public void getSelectTypeLogWarningTest(){
    boolean logError = false;
    boolean logWarning = true;
    boolean logMessage = false;

    int resultType = service.getSelectTypeLog(logError, logWarning, logMessage);
    Assert.assertEquals(resultType, 3);
  }

  @Test
  public void getSelectTypeLogMessageTest(){
    boolean logError = false;
    boolean logWarning = false;
    boolean logMessage = true;

    int resultType = service.getSelectTypeLog(logError, logWarning, logMessage);
    Assert.assertEquals(resultType, 1);
  }

}
