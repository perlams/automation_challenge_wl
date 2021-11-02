To run the tests you need:
1) To clone the project from the github repo
2) Right click on the testng.xml and select the option Run '.../testng.xml'
3) The default setting in the testng.xml is set to run with Chrome. In order to run the tests
with Edge or Firefox, you need to modify the parameter value to 'edge' or 
'firefox' -->  <parameter name="browser" value="chrome"></parameter>
4) The default setting is set to run all browsers as headless. In order to run opening the browsers 
you need to comment the line 'options.addArguments("headless");' from the utils.BrowserFactory class.
5) 