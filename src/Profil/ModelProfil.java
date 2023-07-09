package Profil;

public class ModelProfil {
    private String username,nama,alamat,email,password,nomorHP;

    public ModelProfil(String username, String nama, String alamat, String email, String password, String nomorHP) {
        this.username = username;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.password = password;
        this.nomorHP = nomorHP;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNomorHP() {
        return nomorHP;
    }
    public void setNomorHP(String nomorHP) {
        this.nomorHP = nomorHP;
    }
}
