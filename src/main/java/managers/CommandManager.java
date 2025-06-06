package managers;

import commands.Executable;

import java.util.HashMap;
import java.util.Map;


public class CommandManager {
    private final Map<String, Executable> commandMap;

    public CommandManager(HashMap<String, Executable> ExecutableHashMap) {
        this.commandMap = ExecutableHashMap;
    }

    public void setUpCommand(Executable command) {
        commandMap.put(command.toString(), command);
    }

    public final Map<String, Executable> getCommands() {
        return commandMap;
    }

    public void setUserRequest(String[] splitedRequest) {
        String request = splitedRequest[0];
        if (!this.getCommands().containsKey(request)) {
            System.out.println("Команда не распознана! Введите 'help' для ознакомления с перечнем команд.");
            return;
        }
        Executable command = this.getCommands().get(request);
        command.execute(splitedRequest);
    }
}

