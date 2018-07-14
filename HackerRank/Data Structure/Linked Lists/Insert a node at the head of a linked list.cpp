Node* Insert(Node *head,int data)
{
  // Complete this method
    Node*newnode=(Node*)malloc(sizeof(Node));
    newnode->data=data;
    
    if(head==NULL)
    {
        newnode->next=NULL;
        head=newnode;
    }
    else
    {
    Node*temp=head;
    newnode->next=head;
    
    }
    return newnode;
    
}