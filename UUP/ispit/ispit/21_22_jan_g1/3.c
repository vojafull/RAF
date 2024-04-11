#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Osoba{

    char ime[25];
    char dijeta[25];

    int kg;

    struct Osoba* left;
    struct Osoba* right;

}Node;


Node* Novi(char ime[], char dijeta[], int kg){

    Node*  novi = (Node*)malloc(sizeof(Node));
    strcpy(novi->ime,ime);
    strcpy(novi->dijeta,dijeta);
    novi->kg=kg;

    novi->left=NULL;
    novi->right=NULL;

    return novi;

}

Node* dodaj(Node* root, Node* novi){

    if(root==NULL) return novi;

    if(strcmp(novi->dijeta,root->dijeta)>=0) root->right=dodaj(root->right, novi);
    if(strcmp(novi->dijeta,root->dijeta)<0) root->left=dodaj(root->left, novi);

    return root;
}


Node* ucitaj(char fajl[]){

    FILE* fp=fopen(fajl,"r");
    Node* root=NULL;
    char linija[255];

    while(fgets(linija,255,fp)){
        if(linija[strlen(linija)-1]=='\n') linija[strlen(linija)-1]=='\0';

        char ime[25];
        char dijeta[25];
        int kg;

        char* token=strtok(linija,",");
        strcpy(ime,token);
        token=strtok(NULL,",");
        strcpy(dijeta,token);
        token=strtok(NULL,",");
        kg=atoi(token);


        Node* novi=Novi(ime,dijeta,kg);

        root=dodaj(root,novi);

    }
    fclose(fp);
    return root;

}

void ispis(Node* root){

    if(root){
        ispis(root->left);
        printf("Na dijeti %s, %s je izgubio %dkg\n", root->dijeta,root->ime, root->kg);
        ispis(root->right);
    }
}

void efik(Node* root, int *suma, int *brd, float *max, char naziv[], char maxnaziv[]){

    if(root==NULL) return;

    efik(root->left,suma,brd,max,naziv,maxnaziv);

    if(*max==-1){
        *max=0;
        strcpy(naziv, root->dijeta);
    }

    if(strcmp(naziv,root->dijeta)!=0){
        float efikasnost=1.0*(*suma)/(*brd);

        if(efikasnost>*max){
            *max=efikasnost;
        strcpy(maxnaziv, root->dijeta);
        }

        *suma=root->kg;
        *brd=1;
        strcpy(naziv, root->dijeta);

    }
    else{
        (*suma) += root->kg;
        (*brd)++;
    }

    efik(root->right,suma,brd,max,naziv,maxnaziv);



}

void Lower(char str[]){

    for(int i=0;i<strlen(str);i++){
        if(str[i]>='A' && str[i]<='Z')
            str[i] = str[i]+'a'-'A';
    }

}




void NadjiMe(Node* root, char str[]){

    if(root==NULL) return;

    char oi[25];
    strcpy(oi,root->ime);

    Lower(oi);
    Lower(str);

    if(strstr(oi,str)!=NULL){
        printf("Na dijeti %s, %s je izgubio %dkg\n", root->dijeta,root->ime, root->kg);
    }

    NadjiMe(root->left,str);
    NadjiMe(root->right,str);

}



void Obrisi(Node* root){

    if(root){
        Obrisi(root->left);
        Obrisi(root->right);
        free(root);
    }
}

void meni(){

    printf("1. Ucitaj podatke\n");

    printf("2. Ispis podataka\n");

    printf("3. Najefikasnija dijeta\n");

    printf("4. Pronadji osobu\n");

    printf("0. Izlaz\n");


}

int main()
{
    int br;

    Node* root=NULL;

   char max_naziv[20] = "";
    char naziv[20] = "";
    float max = -1;
    int suma = 0;
    int brd = 0;
    float efikasnost;

    meni();
    while(scanf("%d", &br)!=0){

        if(br==1){
            printf("Unesite ime fajla: ");
            char fajl[25];
            scanf("%s", &fajl);
            root=ucitaj(fajl);

        }
        else if(br==2) { ispis(root);}
        else if(br==3) {
                strcpy(max_naziv, "");
                strcpy(naziv, "");
                max = -1;
                suma = 0;
                brd = 0;
            efik(root,&suma,&brd,&max,naziv, max_naziv);
            efikasnost=1.0*suma/brd;
            if(efikasnost>max){
                max=efikasnost;
                strcpy(max_naziv, naziv);

            }
            printf("Najefikasnija dijeta: %s, kg: %.2f\n", max_naziv, max);

        }
        else if(br==4)  {
            printf("Unesite ime osobe: ");
            char ime[25];
            scanf("%s", ime);
            NadjiMe(root,ime);

        }
        else if (br==0){Obrisi(root); break;}

        system("pause");
        system("cls");
        meni();

    }

    return 0;
}
