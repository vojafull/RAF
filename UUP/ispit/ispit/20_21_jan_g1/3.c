#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Lista{

    int rbr;
    char predmet[5];
    int *ocene;

    int i;

    struct Lista* sledeci;

}Lista;

typedef struct Lista2{

    int rbr;
    char predmet[5];
    int* ocene;

    struct Lista2* sledeci;

}Lista2;


Lista* napraviNovi(int rbr, char predmet[], int ocene[], int i){

    Lista* novi=(Lista*)malloc(sizeof(Lista));

    novi->rbr=rbr;
    strcpy(novi->predmet,predmet);
    novi->i=i;

    novi->ocene=malloc(sizeof(ocene));

    for(int j=0; j<i;j++){
            if(ocene[j]>=1 && ocene[j]<=5){
            novi->ocene[j]=ocene[j];
            //printf("%d ", novi->ocene[j]);
           }
            else break;
        }
    novi->sledeci=NULL;
    return novi;
}

Lista* pocetak(Lista* head, Lista* novi){

    novi->sledeci=head;
    return novi;
}

Lista* ubaci22(Lista* head, Lista* novi){

    if(head==NULL) return pocetak(head,novi);

    Lista* tmp=head;

    while(head->sledeci!=NULL && strcmp(novi->predmet,head->sledeci->predmet)>0)
    {
            head=head->sledeci;

    }


    if(head->sledeci==NULL){
        head->sledeci=novi;
        return tmp;
    }



    novi->sledeci=head->sledeci;
    head->sledeci=novi;

    return tmp;

}



Lista* ubaci1(Lista* head, Lista* novi){

    if (head == NULL || (head->rbr > novi->rbr) || (head->rbr == novi->rbr && strcmp(head->predmet, novi->predmet) > 0)) return pocetak(head,novi);


    // if(head->rbr > novi->rbr) return pocetak(head,novi);


    Lista* tmp=head;
/*
    if( head->sledeci!=NULL && head->sledeci->rbr==novi->rbr){
        // printf("NOVI.  %d. %s\nSLEDECI.  %d. %s\nSTARI.  %d. %s\n", novi->rbr,novi->predmet,head->sledeci->rbr,head->sledeci->predmet);

        if(strcmp(novi->predmet,head->sledeci->predmet)>0){

              head=ubaci22(head->sledeci,novi);

        }
        else{
            novi->sledeci=head->sledeci;
            head->sledeci=novi;
        }
        return tmp;
    }
*/
    while (head->sledeci != NULL && (head->sledeci->rbr < novi->rbr || (head->sledeci->rbr == novi->rbr && strcmp(head->sledeci->predmet, novi->predmet) < 0)))
    {
            head=head->sledeci;

    }


    novi->sledeci = head->sledeci;
    head->sledeci = novi;

    return tmp;

}


int provera(Lista* head, int rbr){


    while(head){
        if(head->rbr!=rbr) return 1;
        head=head->sledeci;
    }
    return 0;

}

Lista* ucitaj2(Lista* head){

    Lista* head2=NULL;
    Lista* tmp=head;
    while(tmp){
            if(!provera(head2,tmp->rbr)){
            Lista* novi=napraviNovi(tmp->rbr,tmp->predmet,tmp->ocene,tmp->i);
           // head2=ubaci2(head2,novi);

            }

    tmp=tmp->sledeci;

    }
    return head2;
}

Lista* dodaju(char fajl[]){

    FILE* fp=fopen(fajl,"r");
    Lista* head=NULL;

    char linija[255];
    while(fgets(linija,254,fp)){
     if(linija[strlen(linija)-1]=='\n') linija[strlen(linija)-1]='\0';

        char* token=strtok(linija," ");

        int rbr=atoi(token);

        token=strtok(NULL," ");

        char predmet[5];
        strcpy(predmet,token);
        int i=0, a[5];
        token=strtok(NULL," ");

        while(token){
            a[i]=atoi(token);
            i++;
            token=strtok(NULL," ");
        }
        /*
        printf("%d. %s\t %d\n", rbr,predmet,i);
        for(int j=0;j<i;j++){
            printf("%d ", a[j]);
        }
        putchar('\n');
        */
        Lista* novi=napraviNovi(rbr,predmet,a,i);



        head=ubaci1(head,novi);
    }
    fclose(fp);
    return head;
}

int brOcena(Lista* head, int prva, int druga, char predmet[]){
    int brojac=0;

    while(head){
        if(strcmp(head->predmet,predmet)==0){
            for(int i=0; i<head->i;i++){
                if((head->ocene[i])>=prva && (head->ocene[i])<=druga) brojac++;

            }
        }
        head=head->sledeci;
    }

    return brojac;

}

Lista* unesiOcenu(Lista* head, int rbr, char predmet[], int ocena){


    while(head){

        if(head->rbr==rbr && strcmp(head->predmet,predmet)==0){

            if(head->i>=5) return NULL;
                else{
                    int omg=head->i;
                    head->ocene[omg]=ocena;
                    head->i=omg + 1;
                    return head;
                }

           }

        head=head->sledeci;
    }

}


Lista* brisi(Lista* head){
    Lista* tmp;
    while(head){
        tmp=head;
        head=head->sledeci;
        free(tmp);
    }
    return head;
}

void Ispis(Lista* head){

    while(head){
        printf("%d\t%s - ", head->rbr,head->predmet);
        for(int i=0; i<head->i;i++){
                if((head->ocene[i])>=1 && (head->ocene[i])<=5)
           printf("%d ", head->ocene[i], head->i);
        }
       // printf("\n%d", head->i);
        putchar('\n');
        head=head->sledeci;
    }

}


void meni(){

    printf("1. Ucitavanje\n");
    printf("2. Br ocena na predmetu\n");
    printf("3. Dodaj ocenu\n");
    printf("4. ISPIS\n");
    printf("0. Izlaz\n");
}

int main()
{
int op;
    Lista* head=NULL;
    Lista* head2=NULL;

    meni();
    while(scanf("%d",&op)!=0){

        if(op==1){
            printf("unesite ime fajla: \n");
            head=dodaju("ocene1.txt");
            head2=ucitaj2(head);
            Ispis(head);
        }
        if(op==2){
            printf("Uneti predmet: \n");
            char predmet[5];
            scanf("%s", &predmet);
            getchar();
            printf("Uneti raspon ocena: \n");
            char lin[5];
            fgets(lin,4,stdin);
            int prva=atoi(strtok(lin," "));
            int druga=atoi(strtok(NULL," "));

            int broj=brOcena(head,prva,druga,predmet);

            printf("%d ocena\n", broj);
        }
        if(op==3){
            printf("Uneti r.br. ucenika\n");
            int rbr;
            scanf("%d",&rbr);
            printf("%d\n",rbr);
            printf("Uneti predmet: \n");
            char predmet[5];
            scanf("%s", &predmet);
            getchar();
            printf("Uneti ocenu: \n");
            int ocena;
            scanf("%d",&ocena);

            Lista* omg=unesiOcenu(head,rbr,predmet,ocena);
            if(omg==NULL){
               printf("Ucenik ima 5 ocena!\n");
            }
            else {

                     Ispis(head);
        }
        }
        if(op==4) Ispis(head);
        if(op==0){
        head=brisi(head);
            break;
        }

        system("pause");
        system("cls");
        meni();
    }



    return 0;
}
