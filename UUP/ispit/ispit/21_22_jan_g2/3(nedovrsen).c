#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int brojac=0;

typedef struct Osoba{

    char ime[25];
    int visina;
    int tezina;

    struct Osoba* left;
    struct Osoba* right;

}Node;

Node* Novi(char ime[], int visina, int tezina){

    Node* novi=(Node*)malloc(sizeof(Node));
    strcpy(novi->ime,ime);
    novi->visina=visina;
    novi->tezina=tezina;

    novi->left=NULL;
    novi->right=NULL;

}


Node* dodaj(Node* root, Node* novi){

    if(root==NULL) return novi;

    if(strcmp(novi->ime,root->ime)>=0) root->right=dodaj(root->right,novi);
    if(strcmp(novi->ime,root->ime)<0) root->left=dodaj(root->left,novi);

    return root;
}

Node* dodajPoTezini(Node* root, Node* novi){

    if(root==NULL) return novi;

    printf("%s je visok/a %d, a tezak/ska %d\n", novi->ime,novi->visina, novi->tezina);


    if(root->tezina>=novi->tezina) root->right=dodajPoTezini(root->right,novi);
    if(root->tezina<novi->tezina) root->left=dodajPoTezini(root->left,novi);

    return root;
}


Node* ucitaj(char fajl[]){

    FILE* fp=fopen(fajl,"r");
    char linija[255];
    Node* root=NULL;

    while(fgets(linija,255,fp)){

        char ime[25];
        int visina, tezina;

        char* token=strtok(linija,",");
        strcpy(ime,token);
        token=strtok(NULL,",");
        visina=atoi(token);
        token=strtok(NULL,",");
        tezina=atoi(token);

        Node* novi=Novi(ime,visina,tezina);

        root=dodaj(root,novi);
    }


    fclose(fp);
    return root;
}



Node* najvisa(Node* root, Node* max){

    if(root){
        if(root->visina>max->visina) max=root;

        Node* maxL=najvisa(root->left,max);
        if(maxL->visina>max->visina) max=maxL;

         Node* maxR=najvisa(root->right,max);
        if(maxR->visina>max->visina) max=maxR;


        return max;
    }

    return Novi("", 0, 0);

}

Node* najniza(Node* root, Node* min){

    if(root){
        if(root->visina<min->visina)
            min=root;

        Node* maxL=najniza(root->left,min);
        if(maxL->visina<min->visina)
            min=maxL;

         Node* maxR=najniza(root->right,min);
        if(maxR->visina<min->visina)
            min=maxR;


        return min;
    }

    return Novi("", "", 0);

}

void sortiraj(int tezina[]){


    int min_index;
    for(int i=0;i<brojac-1;i++){
        min_index=i;
        for(j=i;j<brojac;j++){
            if(tezina[j]>tezina[min_index]) min_index=j;
        }
        int tmp=tezina[i];
        tezina[i]=tezina[min_index];
        tezina[min_index]=tmp;
    }


}

void laksi(Node* root, int kg, char root1[][25], int toot[]){



    if(root==NULL) return;

    if(root){

    laksi(root->left,kg,root1,toot);

    if(root->tezina<kg){
           strcpy[]
            toot[brojac]=root->tezina;
            brojac++;
    }

    laksi(root->right,kg,root1);

    }

     sortiraj(toot);

     while(brojac>=0){


     }

}

void Ispis(Node* root){

    if(root){
        Ispis(root->left);
        printf("%s je visok/a %d, a tezak/ska %d\n", root->ime,root->visina, root->tezina);
        Ispis(root->right);
    }

}


void izbrisi(Node* root){

    if(root){
        izbrisi(root->left);
         izbrisi(root->right);
         free(root);
    }

}

void meni(){

    printf("1. Ucitavanje podataka\n");
    printf("2. Ispis podataka\n");
    printf("3. Najniza i najvisa osoba\n");
    printf("4. Osobe lakse od x tezine\n");
    printf("0. Izlaz\n");

}


int main()
{
    int op;
    Node* root=NULL;
    char fajl[25];
    meni();
Node* Najniza;

    while( scanf("%d", &op)!=0){

        if(op==1){printf("Unesite ime fajla: ");

            root=ucitaj("fajlG2.txt");
        }
        if(op==2){
                Ispis(root);
        }
        if(op==3){

            Najniza=najniza(root,Novi("",9999,9999));
            Node* Najvisa=najvisa(root,Novi("",0,0));

            printf("%s je najvisi/a sa visinom %d i tezinom %d\n", Najvisa->ime,Najvisa->visina, Najvisa->tezina);
            printf("%s je najnizi/a sa visinom %d i tezinom %d\n", Najniza->ime,Najniza->visina, Najniza->tezina);

        }
        if(op==4){
            printf("Unesite tezinu: ");
            int kg;
            scanf("%d", &kg);
            Node* nov=NULL;
            Node* omg=laksi(root,kg,nov);


            Ispis(omg);
        }
        if(op==0){ break;}

        system("pause");
        system("cls");
        meni();
    }



    return 0;
}
