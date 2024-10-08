package view;

import view.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new GetFamilyTreeInfo(consoleUI));
        commands.add(new Finish(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new LoadTree(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список комманд:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size(){
        return commands.size();
    }
}
