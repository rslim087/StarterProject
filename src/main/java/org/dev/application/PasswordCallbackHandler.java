package org.dev.application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler{
	
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
            System.out.println("HIIIII" + pc.getIdentifier() + " " + pc.getUsage());
			if (pc.getUsage() == WSPasswordCallback.SIGNATURE || pc.getUsage() == WSPasswordCallback.DECRYPT)
				if (pc.getIdentifier().equals("server"))
					pc.setPassword("password");
		}
    }
}



















// public class PasswordCallbackHandler implements CallbackHandler {

//     Map<String, String> passwords = new HashMap<>();

// //     public PasswordCallbackHandler() {
// //    //     passwords.put("sumuser", "sumpass"); //in real-world, this is in database.
// //         passwords.put("myservicekey", "skpass");
// //     }
//     @Override
//     public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
//         for (Callback callback : callbacks) {
//             WSPasswordCallback pc = (WSPasswordCallback)callback; //get the userId out of this callback
//             //interceptor will put the user id that came in the request into the callback
//             //
//             pc.getIdentifier(); //userId that came in the request
//             System.out.println("HIIIIII" +pc.getIdentifier());

//             String password = passwords.get(pc.getIdentifier());
//             pc.setPassword(password); //4
//         }        
//     }
// }







// package org.dev.application;

// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Map;

// import javax.security.auth.callback.Callback;
// import javax.security.auth.callback.CallbackHandler;
// import javax.security.auth.callback.UnsupportedCallbackException;
// import org.apache.wss4j.common.ext.WSPasswordCallback;

// public class PasswordCallbackHandler implements CallbackHandler {

//     Map<String, String> passwords = new HashMap<>();

//     public PasswordCallbackHandler() {
//    //     passwords.put("sumuser", "sumpass"); //in real-world, this is in database.
//         passwords.put("server", "password");
//     }
//     @Override
//     public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
//         for (Callback callback : callbacks) {
//             WSPasswordCallback pc = (WSPasswordCallback)callback; //get the userId out of this callback
//             pc.setPassword("password"); //4
//         }        
//     }
// }
