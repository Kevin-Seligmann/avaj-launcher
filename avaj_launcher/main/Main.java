package avaj_launcher.main;

import avaj_launcher.parser.Parser;

class Main {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("usage: 'sh run.sh file'");
            return ;
        }
        Parser parser = new Parser();
        parser.openFile(args[0]);
        parser.printFile();
    }
}
