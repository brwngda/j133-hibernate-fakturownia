package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaListaFaktura implements Komenda {
    private DataAccessObject<Faktura> dao;

    @Override
    public String getKomenda() {
        return "listuj faktury";
    }

    @Override
    public void obsluga() {
        List<Faktura> faktury = dao.findAll(Faktura.class);
        faktury.forEach(System.out::println);
    }
}