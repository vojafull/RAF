#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Teretana{

    char opstina[25];
    char ime[25];
    int sprave;
    int kardio;

   struct Teretana* left;
    struct Teretana* right;
}Node;

Node* noviCvor(char ime[], char opstina[], int sprave, int kardio){

    Node* novi=(Node*)malloc(sizeof(Node));

    strcpy(novi->ime,ime);
    strcpy(novi->opstina,opstina);
    novi->sprave=sprave;
    novi->kardio=kardio;

    novi->left=NULL;
    novi->right=NULL;

    return novi;

}

Node* dodajUStablo(Node* root, Node* novi){

    if(root==NULL) return novi;

    if(strcmp(novi->opstina,root->opstina)>=0) root->left=dodajUStablo(root->left,novi);
    if(strcmp(novi->opstina,root->opstina)<0) root->right=dodajUStablo(root->right,novi);

    return root;
}


Node* ucitaj(){

    FILE* fp=fopen("ulaz3.txt","r");
    Node* root=NULL;

    char linija[255];
    while(fgets(linija,255,fp)){
        if(linija[strlen(linija)-1]=='\n') linija[strlen(linija)-1]='\0';

        char ime[25];
        char opstina[25];
        int sprave;
        int kardio;

        char* token=strtok(linija,"-");
        strcpy(opstina,token);
        token=strtok(NULL,"-");
        strcpy(ime,token);
        token=strtok(NULL,"-");
        sprave=atoi(token);
        token=strtok(NULL,"-");
        kardio=atoi(token);

        Node* novi=noviCvor(ime,opstina,sprave,kardio);

        root=dodajUStablo(root,novi);
    }

    fclose(fp);
    return root;
}


void veciOd(Node* root, int brojsprava){

    if(root){

        veciOd(root->left, brojsprava);

        if(brojsprava<(root->sprave-root->kardio)) printf("%s  -  %s  -  %d  -  %d\n", root->opstina, root->ime, root->sprave,root->kardio);

        veciOd(root->right, brojsprava);

    }



}


void TaOpstina(Node* root, char ta[]){

    if(root){

        TaOpstina(root->left, ta);

        if(strstr(root->opstina,ta)) printf("%s  -  %s  -  %d  -  %d\n", root->opstina, root->ime, root->sprave,root->kardio);

        TaOpstina(root->right, ta);

    }
}


void IspisStabla(Node* root){


    if(root){

        IspisStabla(root->right);
        printf("%s  -  %s  -  %d  -  %d\n", root->opstina, root->ime, root->sprave,root->kardio);
        IspisStabla(root->left);

    }

}

void ObrisiStablo(Node* root){

    if(root){
        ObrisiStablo(root->left);
        ObrisiStablo(root->right);

        free(root);
    }


}


void meni(){

    printf("1. Ucitavanje podataka\n");
   printf("2. Ispis svih teretana\n");
      printf("3. Ispis teretana sa spravama\n");
         printf("4. Ispisati sve teretane u odredjenoj opstini\n");
            printf("0. Izlaz iz programa i brisanje stabla\n");

}


int main()
{
    int op;
    Node* root=NULL;
    meni();

    while(scanf("%d", &op)!=0){

        if(op==1){
            root=ucitaj();
        }

      else if(op==2){
        IspisStabla(root);
      }

        else if(op==3){
            printf("Uneti broj sprava: ");
            int brojsprava;
            scanf("%d", &brojsprava);
            putchar('\n');

            veciOd(root,brojsprava);
            putchar('\n');
        }

        else if(op==4){
            printf("Uneti opstinu: ");
            char ta[25];
            scanf("%s", &ta);

            TaOpstina(root,ta);
        }

        else if(op==0){
            ObrisiStablo(root);
            break;
        }

        system("pause");
        system("cls");
        meni();
    }


    return 0;
}
