/*
PSEU Training
Day 17: Factory Method Design Pattern
*/
/*

Created by karmel shehadeh

 */

public class main {
    public static void main(String[] arguments) {
        FileFactory fileFactory = new FileFactory();

        //get an object of xmlFile and call its pars method.
        FileParser xmlFile = fileFactory.getType("XML");

        //call draw method of Circle
        xmlFile.pars();

        //get an object of jsonFile and call its pars method.
        FileParser jsonFile = fileFactory.getType("Json");

        //call draw method of Rectangle
        jsonFile.pars();


    }



}
