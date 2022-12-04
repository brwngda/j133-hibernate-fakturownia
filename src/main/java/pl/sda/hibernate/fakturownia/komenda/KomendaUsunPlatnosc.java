package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Platnosc;

public class KomendaUsunPlatnosc implements Komenda {
    private DataAccessObject<Platnosc> dao;

    @Override
    public String getKomenda() {
        return "usun platnosc";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej platnosci:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dao.delete(Platnosc.class, id)) {
            System.out.println("Usunięto platność");
        } else {
            System.err.println("Nie udało się usunąć płatności");
        }
    }
}