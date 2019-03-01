package id.amfg.ecs.db.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import id.amfg.ecs.model.CSIC;

@Entity(tableName = "CSM1")
public class CSM1Entity implements CSIC {
    @PrimaryKey
    private int CICHID;
    private String CIDESC;
    private String CIGRUP;
    private int CIPCFL;
    private int CIRSFL;
    private String CIRSSD;
    private int CISTFL;
    private int CIRFFL;
    private int CIRCST;
    private int CICRDT;
    private int CICRTM;
    private String CICRUS;
    private int CICHDT;
    private int CICHTM;
    private String CICHUS;

    @Override
    public int getCICHID() {
        return CICHID;
    }

    public void setCICHID(int cichid) {
        this.CICHID = cichid;
    }

    @Override
    public String getCIDESC() {
        return CIDESC;
    }

    public void setCIDESC(String cidesc) {
        this.CIDESC = cidesc;
    }

    @Override
    public String getCIGRUP() {
        return CIGRUP;
    }

    public void setCIGRUP(String cigrup) {
        this.CIGRUP = cigrup;
    }

    @Override
    public int getCIPCFL() {
        return CIPCFL;
    }

    public void setCIPCFL(int cipcfl) {
        this.CIPCFL = cipcfl;
    }

    @Override
    public int getCIRSFL() {
        return CIRSFL;
    }

    public void setCIRSFL(int cirsfl) {
        this.CIRSFL = cirsfl;
    }

    @Override
    public String getCIRSSD() {
        return CIRSSD;
    }

    public void setCIRSSD(String cirssd) {
        this.CIRSSD = cirssd;
    }

    @Override
    public int getCISTFL() {
        return CISTFL;
    }

    public void setCISTFL(int cistfl) {
        this.CISTFL = cistfl;
    }

    @Override
    public int getCIRFFL() {
        return CIRFFL;
    }

    public void setCIRFFL(int cirffl) {
        this.CIRFFL = cirffl;
    }

    @Override
    public int getCIRCST() {
        return CIRCST;
    }

    public void setCIRCST(int circst) {
        this.CIRCST = circst;
    }

    @Override
    public int getCICRDT() {
        return CICRDT;
    }

    public void setCICRDT(int cicrdt) {
        this.CICRDT = cicrdt;
    }

    @Override
    public int getCICRTM() {
        return CICRTM;
    }

    public void setCICRTM(int cicrtm) {
        this.CICRTM = cicrtm;
    }

    @Override
    public String getCICRUS() {
        return CICRUS;
    }

    public void setCICRUS(String cicrus) {
        this.CICRUS = cicrus;
    }

    @Override
    public int getCICHDT() {
        return CICHDT;
    }

    public void setCICHDT(int cichdt) {
        this.CICHDT = cichdt;
    }

    @Override
    public int getCICHTM() {
        return CICHTM;
    }

    public void setCICHTM(int cichtm) {
        this.CICHTM = cichtm;
    }

    @Override
    public String getCICHUS() {
        return CICHUS;
    }

    public void setCICHUS(String cichus) {
        this.CICHUS = cichus;
    }

    @Ignore
    public CSM1Entity(
            int cichid
            , String cidesc
            , String cigrup
            , int cipcfl
            , int cirsfl
            , String cirssd
            , int cistfl
            , int cirffl
            , int circst
            , int cicrdt
            , int cicrtm
            , String cicrus
            , int cichdt
            , int cichtm
            , String cichus
    ) {
        this.CICHID = cichid;
        this.CIDESC = cidesc;
        this.CIGRUP = cigrup;
        this.CIPCFL = cipcfl;
        this.CIRSFL = cirsfl;
        this.CIRSSD = cirssd;
        this.CISTFL = cistfl;
        this.CIRFFL = cirffl;
        this.CIRCST = circst;
        this.CICRDT = cicrdt;
        this.CICRTM = cicrtm;
        this.CICRUS = cicrus;
        this.CICHDT = cichdt;
        this.CICHTM = cichtm;
        this.CICHUS = cichus;
    }

    public CSM1Entity(CSIC csic) {
        this.CICHID = csic.getCICHID();
        this.CIDESC = csic.getCIDESC();
        this.CIGRUP = csic.getCIGRUP();
        this.CIPCFL = csic.getCIPCFL();
        this.CIRSFL = csic.getCIRSFL();
        this.CIRSSD = csic.getCIRSSD();
        this.CISTFL = csic.getCISTFL();
        this.CIRFFL = csic.getCIRFFL();
        this.CIRCST = csic.getCIRCST();
        this.CICRDT = csic.getCICRDT();
        this.CICRTM = csic.getCICRTM();
        this.CICRUS = csic.getCICRUS();
        this.CICHDT = csic.getCICHDT();
        this.CICHTM = csic.getCICHTM();
        this.CICHUS = csic.getCICHUS();
    }

}
