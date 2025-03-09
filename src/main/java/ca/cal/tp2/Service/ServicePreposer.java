package ca.cal.tp2.Service;

import ca.cal.tp2.BDException;
import ca.cal.tp2.Repository.CDRepository;
import ca.cal.tp2.Repository.DVDRepository;
import ca.cal.tp2.Repository.LivreRepository;
import ca.cal.tp2.Service.DTO.CDDTO;
import ca.cal.tp2.Service.DTO.DVDDTO;
import ca.cal.tp2.Service.DTO.LivreDTO;

public class ServicePreposer {

    private final LivreRepository livreRepository;
    private final CDRepository cdRepository;
    private final DVDRepository dvdRepository;

    public ServicePreposer(LivreRepository livreRepository, CDRepository cdRepository, DVDRepository dvdRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public void saveLivre(LivreDTO livreDTO) throws BDException {
        try {
            livreRepository.save(livreDTO.toLivre(livreDTO));
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    public void saveCD(CDDTO cdDTO) throws BDException {
        try {
            cdRepository.save(cdDTO.toCD(cdDTO));
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

    public void saveDVD(DVDDTO dvdDTO) throws BDException {
        try {
            dvdRepository.save(dvdDTO.toDVD(dvdDTO));
        } catch (Exception e) {
            throw new BDException(e.getMessage());
        }
    }

}
