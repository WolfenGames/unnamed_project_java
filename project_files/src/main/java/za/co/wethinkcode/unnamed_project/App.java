package za.co.wethinkcode.unnamed_project;

import za.co.wethinkcode.unnamed_project.src.unnamed.Core.Application.Application;

/**
 * Hello world!
 *
 */
public class App 
{
    static Application app = new Application();
    public static void main( String[] args )
    {
        System.console().printf("Hello World\n");
        if (app == null)
        {
            System.console().printf("Failed\n");
        }
        else {
            try {
                app.Run();
            } catch (NullPointerException ex)
            {
                System.console().printf("Failed %s", ex.toString());
            }
        }
    }
}
