package lyskal.map.hashmap.accountsofclients;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(final String[] args) {
		Map<String, Client> clients = new TreeMap<>();
		clients.put("№765673", new Client("Malish", "Irina", "Alexeevna", "13.05.1990", 5000));
		clients.put("№062070", new Client("Filin", "Denis", "Viktorovich", "20.11.1993", Client.MINIMUM_AMOUNT_OF_CREDIT));
		clients.put("№405602", new Client("Verena", "Marina", "Denisova", "01.09.1980", 2500));
		
		show(clients);
	}

	public static void show(final Map<String, Client> clients) {
		for (Entry<String, Client> client: clients.entrySet()) {
			System.out.println(client.getKey() + " : " + client.getValue().toString());
		}		
		
	}

}