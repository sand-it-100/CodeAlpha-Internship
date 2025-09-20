import java.util.*;

public class AIChatBot {
    private static HashMap<String, String> responses = new HashMap<>();

    // Predefined FAQs
    static {
        responses.put("hi", "Hello! How can I help you?");
        responses.put("hello", "Hi there! Ask me anything.");
        responses.put("how are you", "I'm just a program, but I'm doing great!");
        responses.put("your name", "I am a simple AI ChatBot created in Java.");
        responses.put("bye", "Goodbye! Have a nice day.");
        responses.put("help", "I can answer basic questions. Try asking about me!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== AI ChatBot =====");
        System.out.println("Type 'bye' to exit the chat.");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine().toLowerCase().trim();

            if (userInput.equals("bye")) {
                System.out.println("Bot: " + responses.get("bye"));
                break;
            }

            // Find response
            String response = getResponse(userInput);
            System.out.println("Bot: " + response);
        }

        sc.close();
    }

    private static String getResponse(String input) {
        // Exact match
        if (responses.containsKey(input)) {
            return responses.get(input);
        }
        // Keyword based simple NLP
        if (input.contains("weather")) {
            return "I cannot check live weather, but usually it's sunny somewhere!";
        }
        if (input.contains("time")) {
            return "I cannot give exact time, but you can check your system clock!";
        }
        if (input.contains("java")) {
            return "Java is a popular programming language, platform-independent and OOP based.";
        }
        return "Sorry, I don't understand that. Can you try asking something else?";
    }
}
