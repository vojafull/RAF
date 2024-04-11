#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Tree{

    char tim[25];
    int gol_d;
    int gol_g;

    struct Tree* left;
    struct Tree* right;

}Node;

typedef struct Tree1{

    char tim[25];
    int golovi;
    int gol_d;
    int gol_g;

    struct Tree1* left;
    struct Tree1* right;

}Efik;

Efik* noviCvor1(char tim[], int gold, int golg){

    Efik* novi=(Efik*)malloc(sizeof(Efik));

    strcpy(novi->tim,tim);
    novi->golovi=gold+golg;
    novi->gol_d=gold;
    novi->gol_g=golg;

    novi->left=NULL;
    novi->right=NULL;

    return novi;

}



Node* noviCvor(char tim[], int gold, int golg){

    Node* novi=(Node*)malloc(sizeof(Node));

    strcpy(novi->tim,tim);


    novi->gol_d=gold;
    novi->gol_g=golg;

    novi->left=NULL;
    novi->right=NULL;

    return novi;
}

Node* dodaj(Node* root, char tim[], int gd, int gg){

    if(root==NULL) return noviCvor(tim,gd,gg);

    if(strcmp(tim,root->tim)>0) root->right=dodaj(root->right, tim,gd,gg);
    else if(strcmp(tim,root->tim)<0) root->left=dodaj(root->left, tim,gd,gg);
    else {
        root->gol_d += gd;
        root->gol_g += gg;
    }

    return root;

}

Efik* dodajE(Efik* root, Efik* novi){

    if(root==NULL) return novi;

    if((root->golovi>novi->golovi) || (root->golovi==novi->golovi && root->gol_d>novi->gol_d) || (root->golovi==novi->golovi && root->gol_d==novi->gol_d && strlen(root->tim)<strlen(novi->tim))) root->right=dodajE(root->right,novi);
    else root->left=dodajE(root->left,novi);

    return root;

}

Efik* ucitajE(Node* efik, Node* root){

    if(root){
        ucitajE(efik,root->left);
        Node* novi=noviCvor1(root->tim,root->gol_d,root->gol_g);
        efik=dodajE(efik,novi);
        ucitajE(efik,root->right);
    }

}

Node* ucitaj1(){

    FILE* fp=fopen("ulaz1.txt","r");
    Node* root=NULL;
    char linija[255];

    while(fgets(linija,254,fp)){
        if(linija[strlen(linija)-1]=='\n') linija[strlen(linija)-1]='\0';

        char gost[25];
        int gol_d;
        int gol_g;
        char domacin[25];

        char* token=strtok(linija,",");
        strcpy(domacin,token);

        token=strtok(NULL,":");
        gol_d=atoi(token);
        token=strtok(NULL,",");
        gol_g=atoi(token);
        token=strtok(NULL,",");
        strcpy(gost,token);



        root=dodaj(root,domacin,gol_d,gol_g);
        root=dodaj(root,gost,gol_d,gol_g);

    }


    fclose(fp);
    return root;
}


Node* MAX(Node* root, Node* max){


    if(root){
        if(root->gol_g>max->gol_g) max=root;

        Node* maxL=MAX(root->left,max);
        if(maxL->gol_g>max->gol_g) max=maxL;

         Node* maxR=MAX(root->right,max);
        if(maxR->gol_g>max->gol_g) max=maxR;


        return max;
    }

    return noviCvor("", 0, 0);
}


void IspisMax(Node* root, int max){

    if(root!=NULL){
        IspisMax(root->left, max);
        if(root->gol_g == max) printf("%s\n", root->tim);
        IspisMax(root->right, max);
    }

}

void Ispis(Node* root){

    if(root!=NULL){
        Ispis(root->left);
        printf("%s %d %d\n", root->tim, root->gol_d, root->gol_g);
        Ispis(root->right);
    }

}

void Ispisaaa(Efik* root){

    if(root){
        Ispisaaa(root->left);
        printf("%d %d %s\n",root->golovi,root->gol_d, root->tim);
        Ispisaaa(root->right);
    }

}

void Izbrisi(Node* root){

    if(root){
        Izbrisi(root->left);
        Izbrisi(root->right);
        free(root);
    }

}




void meni(){

    printf("1. Ucitaj\n");
    printf("2. Ispis svih timova.\n");
    printf("3. Ispis podataka o timovima sa najvecim brojem golova u gostima.\n");
    printf("4. Ispis podataka o n najefikasnijih timova.\n");
    printf("0. Izlaz\n");
}

int main()
{
    int op;
    Node* root=NULL;
    Node* efik=NULL;

    meni();
    while(scanf("%d",&op)!=0){

        if(op==1){
            root=ucitaj1(root);

        efik=ucitajE(efik,root);

        }
        if(op==2){

            Ispis(root);
            putchar('\n');

            Ispisaaa(efik);
        }
        if(op==3){
            Node* max=MAX(root,noviCvor("",0,0));

            IspisMax(root,max->gol_g);
            Izbrisi(max);
        }
        if(op==4){
    int n;
    scanf("%d", &n);
   // prvihN(efik,n,0);

        }
        if(op==0){
                Izbrisi(root);
                Izbrisi(efik);
            break;
        }

        system("pause");
        system("cls");
        meni();
    }


    return 0;
}
