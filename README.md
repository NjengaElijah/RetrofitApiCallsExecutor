# RetrofitApiCallsExecutor
Api Call Executor for retrofit
The CallExecutor executes an Api call in a background thread.
Communitaces via the Call interface class which has three callback methods
<br>
<br>
  <code>onStart();</code>
<br>
  <code>onError(Exception e);</code>
<br>
  <code>onComplete(ServerResponse response);</code>
<br>
<b>USAGE</b>
<br>
<code>
  new CallExecutor(theactivity,callInterfaceInstance).execute(YourApiIntefceCall)  
</code>
