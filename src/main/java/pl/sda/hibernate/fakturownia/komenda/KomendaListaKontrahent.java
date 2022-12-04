package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

import java.util.List;

public class KomendaListaKontrahent implements Komenda {
    private DataAccessObject<Kontrahent> dao;

    @Override
    public String getKomenda() {
        return "listuj kontrahent";
    }

    @Override
    public void obsluga() {
        List<Kontrahent> firmy = dao.findAll(Kontrahent.class);
        firmy.forEach(System.out::println);
    }
}