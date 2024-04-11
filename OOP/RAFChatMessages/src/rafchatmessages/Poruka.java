package rafchatmessages;

public abstract class Poruka {

    private String posiljalac;

    public Poruka(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    protected abstract String formirajSadrzinu();

    public String formirajIspis() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.posiljalac).append("\n\n");
        String[] a = this.formirajSadrzinu().split("\\n");
        for (String s : a) {
            stringBuilder.append("\t");
            stringBuilder.append(s);
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString().trim();
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }
}
