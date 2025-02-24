package exercise3.command;

/**
 * Command Interface
 * 
 * Description:
 * Defines a contract for executable actions in the application.
 * Each command implements the `execute` method to perform specific functionality.
 * 
 * Key Responsibilities:
 * - Ensure all commands provide an `execute` implementation.
 */

public interface Command {
	void execute();
}