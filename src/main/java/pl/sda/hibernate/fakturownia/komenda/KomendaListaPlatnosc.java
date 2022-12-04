package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Platnosc;

import java.util.List;

public class KomendaListaPlatnosc implements Komenda {
    private DataAccessObject<Platnosc> dao;

    @Override
    public String getKomenda() {
        return "listuj platnosc";
    }

    @Override
    public void obsluga() {
        List<Platnosc> platnosci = dao.findAll(Platnosc.class);
        platnosci.forEach(System.out::println);
    }
}