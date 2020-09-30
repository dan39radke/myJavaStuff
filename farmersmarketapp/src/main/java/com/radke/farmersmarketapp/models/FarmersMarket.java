package com.radke.farmersmarketapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "farmersmarkets")
public class FarmersMarket {

    @Id
    @Column
    private UUID fmid;
    @Column
    private String marketName;
    @Column
    private boolean credit;
    @Column
    private boolean wic;
    @Column
    private boolean wiccash;
    @Column
    private boolean sfmnp;
    @Column
    private boolean snap;
    @Column
    private boolean bakedgoods;
    @Column
    private boolean cheese;
    @Column
    private boolean crafts;
    @Column
    private boolean flowers;
    @Column
    private boolean eggs;
    @Column
    private boolean seafood;
    @Column
    private boolean herbs;
    @Column
    private boolean vegetables;
    @Column
    private boolean honey;
    @Column
    private boolean jams;
    @Column
    private boolean maple;
    @Column
    private boolean meat;
    @Column
    private boolean nursery;
    @Column
    private boolean nuts;
    @Column
    private boolean poultry;
    @Column
    private boolean prepared;
    @Column
    private boolean soap;
    @Column
    private boolean trees;
    @Column
    private boolean wine;

    public FarmersMarket() {
        this.fmid = UUID.randomUUID();
    }

    public UUID getFMID() {
        return fmid;
    }
    public void setFMID(UUID FMID) {
        this.fmid = FMID;
    }

    public String getMarketName() {
        return marketName;
    }
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public boolean isCredit() {
        return credit;
    }
    public void setCredit(boolean credit) { this.credit = credit; }

    public boolean isWic() {
        return wic;
    }
    public void setWic(boolean wic) { this.wic = wic; }

    public boolean isWicCash() {
        return wiccash;
    }
    public void setWicCash(boolean wiccash) { this.wiccash = wiccash; }

    public boolean isSfmnp() {
        return sfmnp;
    }
    public void setSfmnp(boolean sfmnp) {
        this.sfmnp = sfmnp;
    }

    public boolean isSnap() {
        return snap;
    }
    public void setSnap(boolean snap) {
        this.snap = snap;
    }

    public boolean isBakedGoods() {
        return bakedgoods;
    }
    public void setBakedGoods(boolean bakedgoods) {
        this.bakedgoods = bakedgoods;
    }

    public boolean isCheese() {
        return cheese;
    }
    public void setCheese(boolean cheese) { this.cheese = cheese; }

    public boolean isCrafts() {
        return crafts;
    }
    public void setCrafts(boolean crafts) { this.crafts = crafts; }

    public boolean isFlowers() {
        return flowers;
    }
    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public boolean isEggs() {
        return eggs;
    }
    public void setEggs(boolean eggs) {
        this.eggs = eggs;
    }

    public boolean isSeafood() {
        return seafood;
    }
    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public boolean isHerbs() {
        return herbs;
    }
    public void setHerbs(boolean herbs) {
        this.herbs = herbs;
    }

    public boolean isVegetables() {
        return vegetables;
    }
    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public boolean isHoney() {
        return honey;
    }
    public void setHoney(boolean honey) {
        this.honey = honey;
    }

    public boolean isJams() {
        return jams;
    }
    public void setJams(boolean jams) {
        this.jams = jams;
    }

    public boolean isMaple() {
        return maple;
    }
    public void setMaple(boolean maple) {
        this.maple = maple;
    }

    public boolean isMeat() {
        return meat;
    }
    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isNursery() {
        return nursery;
    }
    public void setNursery(boolean nursery) {
        this.nursery = nursery;
    }

    public boolean isNuts() {
        return nuts;
    }
    public void setNuts(boolean nuts) {
        this.nuts = nuts;
    }

    public boolean isPoultry() {
        return poultry;
    }
    public void setPoultry(boolean poultry) {
        this.poultry = poultry;
    }

    public boolean isPrepared() {
        return prepared;
    }
    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public boolean isSoap() {
        return soap;
    }
    public void setSoap(boolean soap) {
        this.soap = soap;
    }

    public boolean isTrees() {
        return trees;
    }
    public void setTrees(boolean trees) {
        this.trees = trees;
    }

    public boolean isWine() {
        return wine;
    }
    public void setWine(boolean wine) {
        this.wine = wine;
    }

}
