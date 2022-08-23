#include <iostream>
#include <cmath>
#include <cstring>
#include <time.h>
using namespace std;
#define MAX_LEVEL 6
const float P = 0.5;

struct node
{
    int value;
    node** forward;
    node(int level, int& value)
    {
        forward = new node * [level + 1];
        memset(forward, 0, sizeof(node*) * (level + 1));
        this->value = value;
    }
};

struct skiplist
{
    node* header;
    int value;
    int level;
    skiplist()
    {
        header = new node(MAX_LEVEL, value);
        level = 0;
    }
    void display();
    int max();
    int min();
    bool search(int&);
    void insert(int&);
    void delete1(int&);
};

bool skiplist::search(int& s_value)
{
    node* x = header;
    for (int i = level; i >= 0; i--)
    {
        while (x->forward[i] != NULL && x->forward[i]->value < s_value)
        {
            x = x->forward[i];
        }
    }
    x = x->forward[0];
    return x != NULL && x->value == s_value;
}

float frand()
{
    return (float)rand() / RAND_MAX;
}


int random_level()
{
    static bool first = true;
    if (first)
    {
        srand((unsigned)time(NULL));
        first = false;
    }
    int lvl = (int)(log(frand()) / log(1. - P));
    return lvl < MAX_LEVEL ? lvl : MAX_LEVEL;
}

void skiplist::display()
{
    const node* x = header->forward[0];
    cout<<"[";
    while (x != NULL)
    {
        
        cout << x->value;
        x = x->forward[0];
        if (x != NULL)
            cout << ",";
        
    }
    cout<<"]";
    cout << endl;
}


void skiplist::insert(int& value)
{
    node* x = header;
    node* update[MAX_LEVEL + 1];
    memset(update, 0, sizeof(node*) * (MAX_LEVEL + 1));
    for (int i = level; i >= 0; i--)
    {
        while (x->forward[i] != NULL && x->forward[i]->value < value)
        {
            x = x->forward[i];
        }
        update[i] = x;
    }
    x = x->forward[0];
    if (x == NULL || x->value != value)
    {
        int lvl = random_level();
        if (lvl > level)
        {
            for (int i = level + 1; i <= lvl; i++)
            {
                update[i] = header;
            }
            level = lvl;
        }
        x = new node(lvl, value);
        for (int i = 0; i <= lvl; i++)
        {
            x->forward[i] = update[i]->forward[i];
            update[i]->forward[i] = x;
        }
    }
}

void skiplist::delete1(int& value)
{
    node* x = header;
    node* update[MAX_LEVEL + 1];
    memset(update, 0, sizeof(node*) * (MAX_LEVEL + 1));
    for (int i = level; i >= 0; i--)
    {
        while (x->forward[i] != NULL && x->forward[i]->value < value)
        {
            x = x->forward[i];
        }
        update[i] = x;
    }
    x = x->forward[0];
    if (x->value == value)
    {
        for (int i = 0; i <= level; i++)
        {
            if (update[i]->forward[i] != x)
                break;
            update[i]->forward[i] = x->forward[i];
        }
        delete x;
        while (level > 0 && header->forward[level] == NULL)
        {
            level--;
        }
    }
}



int skiplist::max()
{
   const node* x = header->forward[0];
   int max= x->value;
    while (x != NULL)
    {
        if (x->value > max)
            max = x->value;  
        x = x->forward[0];      
    }
    return max;
}

int skiplist::min()
{
    const node* x = header->forward[0];
    int min= x->value;
    while (x != NULL)
    {
        if (x->value < min)
            min = x->value;  
        x = x->forward[0];
    }  
  return min;
}




int main() {
    skiplist list;
    int insert;
    int all;
    char b;
    int a;
    char c;
    
    cin>>insert;
    cin>>all;
   
    for (int i=0;i<insert;i++)
    {
     cin>>c;
     cin>>b;
     cin>>c;
     cin>>a;
     cin>>c;
     
     list.insert(a);
    }
    
    for (int i=0; i<all-insert;i++)
    {
     cin>>c;
     cin>>b;
     cin>>c;
     cin>>a;
     cin>>c;
     
     if(b == 'i')
      list.insert(a);
       
     else if (b == 's')
     {
        cout<<"[";
        if(list.search(a)==1)
           cout <<"Yes";
        else 
           cout<<"No";
        cout<<"]";
        cout << endl;
     }
     else if (b == 'd')
      list.delete1(a); 
      
    }
    
   cout<<"["; 
   cout<< list.max(); 
   cout<<"]"; 
   cout << endl;
   cout<<"[";
   cout<< list.min();
   cout<<"]"; 
   cout << endl;
   list.display();
    
   return 0;
}
