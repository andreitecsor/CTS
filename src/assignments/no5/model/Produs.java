package assignments.no5.model;

import assignments.no5.exceptii.ValoriInvalideProdusException;
import assignments.no5.exceptii.ValoriLipsaProdusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *
 * DISCLAIMER
 *
 * Cele mai multe dintre metodele date au bug-uri si greseli de implementare
 *
 *
 * SPECS
 *
 * nume - intre 5 si 200 caractere alfa-numerice (fara caractere speciale)
 * pret - intre [0.01, 100000)
 * valori in produseVanduteSaptamanal - intre [0, 1000]
 *
 *
 */

public class Produs {
    public static final Integer NR_MIN_CARACTERE = 5;
    public static final Integer NR_MAX_CARACTERE = 200;
    public static final Float PRET_MIN = 0.01F;
    public static final Float PRET_MAX = 100000F;
    public static final Integer MIN_PRODUSE_VANDUTE_SAPTAMANA = 0;
    public static final Integer MAX_PRODUSE_VANDUTE_SAPTAMANA = 1000;

    private String nume;
    private float pret;
    private ArrayList<Integer> produseVanduteSaptamanal;

    public Produs(String nume, float pret) throws ValoriInvalideProdusException {
        this.nume = validareNume(nume);
        this.pret = validarePret(pret);
        produseVanduteSaptamanal = new ArrayList<>();
    }

    public Produs(String nume, float pret, ArrayList<Integer> produseVandute)
            throws ValoriInvalideProdusException {
        this.nume = validareNume(nume);
        this.pret = validarePret(pret);
        this.produseVanduteSaptamanal = new ArrayList<>();
        this.produseVanduteSaptamanal.addAll(validareProduseVanduteSaptamanal(produseVandute));
    }

    public String getNume() {
        return this.nume;
    }

    public float getPret() {
        return this.pret;
    }

    public ArrayList<Integer> getProduseVanduteSaptamanal() {
        return produseVanduteSaptamanal;
    }

    public void setVanzari(ArrayList<Integer> produseVandute) throws ValoriInvalideProdusException {
        this.produseVanduteSaptamanal.addAll(validareProduseVanduteSaptamanal(produseVandute));
    }

    public void adaugaSaptamana(int produseVandute) throws ValoriInvalideProdusException {
        if (produseVandute < MIN_PRODUSE_VANDUTE_SAPTAMANA ||
                produseVandute > MAX_PRODUSE_VANDUTE_SAPTAMANA) {
            throw new ValoriInvalideProdusException("Minimul de vanzari pe saptamana este de 0, iar maximul de 1000");
        }
        produseVanduteSaptamanal.add(produseVandute);
    }

    public int getNrProduseVandute(int indexSaptamana) throws ValoriLipsaProdusException {
        if (produseVanduteSaptamanal.isEmpty()) {
            throw new ValoriLipsaProdusException("Nu exista valori pentru lista produselor vandute saptamanal");
        }
        if (indexSaptamana < 0 || indexSaptamana >= produseVanduteSaptamanal.size()) {
            throw new ValoriLipsaProdusException("Nu exista saptamana cautata");
        }
        return produseVanduteSaptamanal.get(indexSaptamana);
    }

    /*
     * determina numarul de saptamani in care au fost vandute un numar de produse peste limita data
     */
    public int getNrSaptamaniPesteMedie(int limitaInferioara) throws ValoriLipsaProdusException {
        if (produseVanduteSaptamanal.isEmpty()) {
            throw new ValoriLipsaProdusException("Nu exista valori pentru lista produselor vandute saptamanal");
        }
        int nrSaptamani = 0;
        for (int produseVandutaPeSaptamana : produseVanduteSaptamanal) {
            if (produseVandutaPeSaptamana >= limitaInferioara) {
                nrSaptamani++;
            }
        }
        return nrSaptamani;
    }

    /*
     * determina procentul saptamanilor (din total saptamani) care au avut vanzari sub limita data
     */
    public float getProcentSaptamaniSlabe(int limitaInferioara) throws ValoriLipsaProdusException {
        if (produseVanduteSaptamanal.isEmpty()) {
            throw new ValoriLipsaProdusException("Nu exista valori pentru lista produselor vandute saptamanal");
        }
        float nrSaptamaniSlabe = 0;
        for (Integer produseVandutaPeSaptamana : produseVanduteSaptamanal) {
            if (produseVandutaPeSaptamana < limitaInferioara) {
                nrSaptamaniSlabe++;
            }
        }
        return (100 * (nrSaptamaniSlabe / this.produseVanduteSaptamanal.size()));
    }

    /*
     * determina indexul saptamanilor cu vanzari maxime (mai multe saptamani pot avea vanzari la nivel maxim)
     */
    public ArrayList<Integer> getIndexSaptamaniCuVanzariMaxime() throws ValoriLipsaProdusException {
        if (produseVanduteSaptamanal.isEmpty()) {
            throw new ValoriLipsaProdusException("Nu exista valori pentru lista produselor vandute saptamanal");
        }
        ArrayList<Integer> saptamaniMax = new ArrayList<>();
        int valoareMaximaDeVanzari = Collections.max(produseVanduteSaptamanal);

        for (int indexSaptamana = 0; indexSaptamana < this.produseVanduteSaptamanal.size(); indexSaptamana++) {
            if (this.produseVanduteSaptamanal.get(indexSaptamana) == valoareMaximaDeVanzari) {
                saptamaniMax.add(indexSaptamana);
            }
        }

        return saptamaniMax;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(this.nume + " vanzari saptamanale: ");
        for (Integer produseVandutePeSaptamana : produseVanduteSaptamanal)
            output.append(produseVandutePeSaptamana).append(" ");
        return output.toString();
    }

    private String validareNume(String nume) throws ValoriInvalideProdusException {
        if (nume == null) {
            throw new ValoriInvalideProdusException("Numele este null");
        }
        if (nume.length() < NR_MIN_CARACTERE || nume.length() > NR_MAX_CARACTERE) {
            throw new ValoriInvalideProdusException("Numele trebuie sa aiba intre 5 si 200 de caractere");
        }
        Pattern RegexPattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = RegexPattern.matcher(nume);
        if (matcher.find()) {
            throw new ValoriInvalideProdusException("Numele trebuie sa nu contina caractere speciale");
        }
        return nume;
    }

    private float validarePret(float pret) throws ValoriInvalideProdusException {
        if (pret < PRET_MIN || pret >= PRET_MAX) {
            throw new ValoriInvalideProdusException("Valoarea pretului este invalida");
        }
        return pret;
    }

    private ArrayList<Integer> validareProduseVanduteSaptamanal(ArrayList<Integer> produseVandute)
            throws ValoriInvalideProdusException {
        if (produseVandute == null) {
            throw new ValoriInvalideProdusException("lista de produse vandute este null");
        }
        for (Integer produseVandutePeSaptamana : produseVandute) {
            if (produseVandutePeSaptamana < MIN_PRODUSE_VANDUTE_SAPTAMANA ||
                    produseVandutePeSaptamana > MAX_PRODUSE_VANDUTE_SAPTAMANA) {
                throw new ValoriInvalideProdusException("Minimul de vanzari pe saptamana este de 0, iar maximul de 1000");
            }
        }
        return produseVandute;
    }

}