 public class SklepKomputerowy {
    private Produkt[] produkty = new Produkt[100];
    private Klient[] klienci = new Klient[100];
    private Zamowienie[] zamowienia = new Zamowienie[100];
    private int liczbaProduktow = 0;
    private int liczbaKlientow = 0;
    private int liczbaZamowien = 0;
    public void dodajProdukt(Produkt produkt) {
        produkty[liczbaProduktow++] = produkt;
    }
    public void dodajKlienta(Klient klient) {
        klienci[liczbaKlientow++] = klient;
    }
    public Zamowienie utworzZamowienie(Klient klient, Produkt[] produktyZam, int[] ilosci) {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setId(liczbaZamowien + 1);
        zamowienie.setKlient(klient);
        zamowienie.setProdukty(produktyZam);
        zamowienie.setIlosci(ilosci);
        zamowienie.setDataZamowienia(new data().toString());
        zamowienie.setStatus("Nowe");
        zamowienia[liczbaZamowien++] = zamowienie;
        return zamowienie;
    }
    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] zamProdukty = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();
        for (int i = 0; i < zamProdukty.length; i++) {
            zamProdukty[i].setIloscWMagazynie(zamProdukty[i].getIloscWMagazynie() - ilosci[i]);
        }
    }
    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                return;
            }
        }
    }
    public void wyswietlProduktyWKategorii(String kategoria) {
        for (int i = 0; i < liczbaProduktow; i++) {
            if (produkty[i].getKategoria().equalsIgnoreCase(kategoria)) {
                produkty[i].wyswietlInformacje();
            }
        }
    }
    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getId() == idKlienta) {
                zamowienia[i].wyswietlSzczegoly();
                System.out.println("-----");
            }
        }
    }
}
