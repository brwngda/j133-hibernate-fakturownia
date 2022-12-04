package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaListaFirma implements Komenda {
    private DataAccessObject<Firma> dao;

    @Override
    public String getKomenda() {
        return "listuj firma";
    }

    @Override
    public void obsluga() {
        List<Firma> firmy = dao.findAll(Firma.class);
        firmy.forEach(System.out::println);
    }
}