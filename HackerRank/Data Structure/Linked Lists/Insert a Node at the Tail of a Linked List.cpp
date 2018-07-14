Node* Insert(Node *head,int data)
{
  // Complete this method
    Node*newnode=(Node*)malloc(sizeof(Node));
    newnode->data=data;
    newnode->next=NULL;
    if(head==NULL)
    {
    head=newnode;
        
    }
    else
    {
    Node*temp=head;
    while(temp->next!=NULL)
    {
    temp=temp->next;
    
    }
        temp->next=newnode;
    
    }
    return head;
}