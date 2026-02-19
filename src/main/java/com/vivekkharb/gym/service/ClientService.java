package com.vivekkharb.gym.service;

import com.vivekkharb.gym.entity.Client;
import com.vivekkharb.gym.repository.ClientRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    // Fetch all clients
    public List<Client> getAllClients() {
        return repository.findAllClientsNative();
    }

    // Add multiple clients
    @Transactional
    public void addMultipleClients(List<Client> clients) {
        for (Client client : clients) {
            repository.insertClientNative(
                    client.getName(),
                    client.getDateOfBirth().toString(),  // convert LocalDate to String
                    client.getGender().name(),           // convert enum to String
                    client.getCourseType().name()        // convert enum to String
            );
        }
    }
}
