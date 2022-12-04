package pl.sda.hibernate.fakturownia.komenda;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

public class KomendaUsunKontrahent implements Komenda {
    private DataAccessObject<Kontrahent> dao;

    @Override
    public String getKomenda() {
        return "usun kontrahent";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego kontrahenta:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dao.delete(Kontrahent.class, id)) {
            System.out.println("Usunięto kontrahenta");
        } else {
            System.err.println("Nie udało się usunąć kontrahenta");
        }
    }
}