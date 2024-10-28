package tn.esprit.tpfoyer.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.service.BlocServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlocServiceImplTest {

    @Mock
    private BlocRepository blocRepository;

    @InjectMocks
    private BlocServiceImpl blocService;

    // Test for retrieveBloc
    @Test
    void testRetrieveBloc() {
        // Arrange
        Long blocId = 1L;
        Bloc bloc = new Bloc();


        // Mock repository call
        when(blocRepository.findById(blocId)).thenReturn(Optional.of(bloc));

        // Act
        Bloc result = blocService.retrieveBloc(blocId);

        // Assert
        assertNotNull(result);

        // Verify repository interaction
        verify(blocRepository, times(1)).findById(blocId);
    }

    // Test for addBloc
    @Test
    void testAddBloc() {
        // Arrange
        Bloc bloc = new Bloc();

        // Mock repository call
        when(blocRepository.save(bloc)).thenReturn(bloc);

        // Act
        Bloc result = blocService.addBloc(bloc);

        // Assert
        assertNotNull(result);

        // Verify repository interaction
        verify(blocRepository, times(1)).save(bloc);
    }

    // Test for removeBloc
    @Test
    void testRemoveBloc() {
        // Arrange
        Long blocId = 1L;

        // Act
        blocService.removeBloc(blocId);

        // Verify repository interaction
        verify(blocRepository, times(1)).deleteById(blocId);
    }
}
