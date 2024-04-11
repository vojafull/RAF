#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Lista{
    int dan;
    int mesec;
    int godina;
    int brbeba;

    struct Lista* sledeci;

}Lista;

typedef struct Lista2{
    int mesec;
    int godina;
    int brbeba;

    struct Lista2* sledeci;

}Lista2;

Lista* pocetak(Lista* head, Lista* novi){
    novi->sledeci=head;
    return novi;

}
Lista2* pocetak2(Lista2* head, Lista2* novi){
    novi->sledeci=head;
    return novi;

}

Lista* napraviNovi(int dan,int mesec, int godina, int brbeba){

    Lista* novi=(Lista*)malloc(sizeof(Lista));
    novi->dan=dan;
    novi->mesec=mesec;
    novi->godina=godina;
    novi->brbeba=brbeba;

    novi->sledeci=NULL;

    return novi;
}

Lista2* napraviNovi2(int mesec, int godina, int brbeba){

    Lista2* novi=(Lista2*)malloc(sizeof(Lista2));

    novi->mesec=mesec;
    novi->godina=godina;
    novi->brbeba=brbeba;

    novi->sledeci=NULL;

    return novi;
}

Lista* dodajPoBr(Lista* head, Lista* novi){

    if(head==NULL) return pocetak(head,novi);

    if(head->brbeba<novi->brbeba) return pocetak(head,novi);

    Lista* tmp=head;
    while(head->sledeci!=NULL && head->sledeci->brbeba > novi->brbeba)
    {
        head=head->sledeci;
    }
    if(head->sledeci==NULL)
    {
        head->sledeci=novi;
        return tmp;
    }
    novi->sledeci=head->sledeci;
    head->sledeci=novi;
    return tmp;


}

Lista2* dodajPoMes(Lista2* head, Lista2* novi){

    if(head==NULL) return pocetak2(head,novi);

    if(head->mesec>novi->mesec) return pocetak2(head,novi);

    Lista* tmp=head;
    while(head->sledeci!=NULL && head->sledeci->mesec < novi->mesec)
    {
        head=head->sledeci;
    }
    if(head->sledeci==NULL)
    {
        head->sledeci=novi;
        return tmp;
    }
    novi->sledeci=head->sledeci;
    head->sledeci=novi;
    return tmp;


}

Lista* ucitaj(char fajl[]){

    Lista* head=NULL;
    FILE* fp=fopen(fajl,"r");
    char linija[255];

    while(fgets(linija,254,fp)){
        if(linija[strlen(linija)-1]=='\n') linija[strlen(linija)-1]=='\0';

        char* dan=strtok(linija," ");
        char* mes=strtok(NULL," ");
        char* god=strtok(NULL," ");
        char* br=strtok(NULL," ");

        Lista* novi=napraviNovi(atoi(dan),atoi(mes),atoi(god),atoi(br));

        head=dodajPoBr(head,novi);
    }

    fclose(fp);
    return head;

}

int provera(Lista2* head,int mesec, int godina){

    while(head){
        if(head->mesec==mesec && head->godina==godina) return 1;
        head=head->sledeci;
    }
    return 0;
}

int saberi(Lista* head, int m, int g){

    int zbir=0;
    while(head){
        if(head->mesec==m && head->godina==g) zbir+=head->brbeba;
        head=head->sledeci;
    }
    return zbir;

}


Lista2* ucitaj2(Lista* head){

    Lista2* head2=NULL;

    while(head){

        if(provera(head2,head->mesec,head->godina)==0){
            Lista* novi=napraviNovi2(head->mesec,head->godina,saberi(head,head->mesec,head->godina));
            head2=dodajPoMes(head2,novi);
        }

        head=head->sledeci;
    }

    return head2;
}

void ispis2(Lista2* head){

    while(head){
        printf("%d.%d. %d\n", head->mesec,head->godina,head->brbeba);
        head=head->sledeci;

    }
}

void ispisi(Lista* head, int god){

    int zbir=0;
    while(head){
           if(head->godina==god)  zbir+=head->brbeba;
        head=head->sledeci;
    }

    printf("%d\n", zbir);
}

int ispisrek(Lista* head, int god, int zbir){

    if(head==NULL) return 0;

     if(head->godina==god) zbir+=head->brbeba;
     else ispisrek(head->sledeci,god, zbir);

     return zbir;
}

void meni(){

    printf("1. Ucitavanje\n");
    printf("2. Ispis za godinu\n");
    printf("3. Ispis po mesecima\n");
    printf("0. Izlaz\n");
}


int main()
{
    int op;
    Lista* head=NULL;
    Lista2* head2=NULL;
    meni();

    while(scanf("%d",&op)!=0){

        if(op==1){
            head=ucitaj("grupa1.txt");
            head2=ucitaj2(head);
        }
        if(op==2){
                printf("Godina: ");
        int god;
        scanf("%d", &god);
        printf("1. Iterativno\n2. Rekurzivno\n");
        int a;
        scanf("%d", &a);

            if(a==1) ispisi(head,god);
            else if(a==2) printf("%d\n", ispisrek(head,god,0));
        }
        if(op==3){

            ispis2(head2);
        }
        if(op==0){

            break;
        }

        system("pause");
        system("cls");
        meni();
    }



    return 0;
}
