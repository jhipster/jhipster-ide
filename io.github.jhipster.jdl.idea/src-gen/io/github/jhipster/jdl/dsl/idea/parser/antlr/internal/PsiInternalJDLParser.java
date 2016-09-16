package io.github.jhipster.jdl.dsl.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import io.github.jhipster.jdl.dsl.idea.lang.JDLElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import io.github.jhipster.jdl.dsl.services.JDLGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalJDLParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'{'", "','", "'}'", "'String'", "'Integer'", "'Long'", "'BigDecimal'", "'Float'", "'Double'", "'Boolean'", "'LocalDate'", "'ZonedDateTime'", "'Blob'", "'AnyBlob'", "'ImageBlob'", "'required'", "'minlength'", "'('", "')'", "'maxlength'", "'pattern'", "'min'", "'max'", "'minbytes'", "'maxbytes'", "'relationship'", "'to'", "'service'", "'with'", "'dto'", "'paginate'", "'angularSuffix'", "'OneToMany'", "'ManyToOne'", "'OneToOne'", "'ManyToMany'", "'serviceClass'", "'serviceImpl'", "'mapstruct'", "'pagination'", "'infiniteScroll'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public PsiInternalJDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalJDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalJDLParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalJDL.g"; }



    	protected JDLGrammarAccess grammarAccess;

    	protected JDLElementTypeProvider elementTypeProvider;

    	public PsiInternalJDLParser(PsiBuilder builder, TokenStream input, JDLElementTypeProvider elementTypeProvider, JDLGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
    		this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "DomainModel";
    	}




    // $ANTLR start "entryRuleDomainModel"
    // PsiInternalJDL.g:52:1: entryRuleDomainModel returns [Boolean current=false] : iv_ruleDomainModel= ruleDomainModel EOF ;
    public final Boolean entryRuleDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDomainModel = null;


        try {
            // PsiInternalJDL.g:52:53: (iv_ruleDomainModel= ruleDomainModel EOF )
            // PsiInternalJDL.g:53:2: iv_ruleDomainModel= ruleDomainModel EOF
            {
             markComposite(elementTypeProvider.getDomainModelElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDomainModel=ruleDomainModel();

            state._fsp--;

             current =iv_ruleDomainModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDomainModel"


    // $ANTLR start "ruleDomainModel"
    // PsiInternalJDL.g:59:1: ruleDomainModel returns [Boolean current=false] : ( (lv_elements_0_0= ruleElements ) )* ;
    public final Boolean ruleDomainModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_elements_0_0 = null;


        try {
            // PsiInternalJDL.g:60:1: ( ( (lv_elements_0_0= ruleElements ) )* )
            // PsiInternalJDL.g:61:2: ( (lv_elements_0_0= ruleElements ) )*
            {
            // PsiInternalJDL.g:61:2: ( (lv_elements_0_0= ruleElements ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==37||LA1_0==39||(LA1_0>=41 && LA1_0<=43)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalJDL.g:62:3: (lv_elements_0_0= ruleElements )
            	    {
            	    // PsiInternalJDL.g:62:3: (lv_elements_0_0= ruleElements )
            	    // PsiInternalJDL.g:63:4: lv_elements_0_0= ruleElements
            	    {

            	    				markComposite(elementTypeProvider.getDomainModel_ElementsElementsParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleElements();

            	    state._fsp--;


            	    				doneComposite();
            	    				if(!current) {
            	    					associateWithSemanticElement();
            	    					current = true;
            	    				}
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDomainModel"


    // $ANTLR start "entryRuleElements"
    // PsiInternalJDL.g:79:1: entryRuleElements returns [Boolean current=false] : iv_ruleElements= ruleElements EOF ;
    public final Boolean entryRuleElements() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElements = null;


        try {
            // PsiInternalJDL.g:79:50: (iv_ruleElements= ruleElements EOF )
            // PsiInternalJDL.g:80:2: iv_ruleElements= ruleElements EOF
            {
             markComposite(elementTypeProvider.getElementsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleElements=ruleElements();

            state._fsp--;

             current =iv_ruleElements; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElements"


    // $ANTLR start "ruleElements"
    // PsiInternalJDL.g:86:1: ruleElements returns [Boolean current=false] : (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting ) ;
    public final Boolean ruleElements() throws RecognitionException {
        Boolean current = false;

        Boolean this_Entity_0 = null;

        Boolean this_Relationships_1 = null;

        Boolean this_GenerationSetting_2 = null;


        try {
            // PsiInternalJDL.g:87:1: ( (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting ) )
            // PsiInternalJDL.g:88:2: (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting )
            {
            // PsiInternalJDL.g:88:2: (this_Entity_0= ruleEntity | this_Relationships_1= ruleRelationships | this_GenerationSetting_2= ruleGenerationSetting )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 37:
                {
                alt2=2;
                }
                break;
            case 39:
            case 41:
            case 42:
            case 43:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // PsiInternalJDL.g:89:3: this_Entity_0= ruleEntity
                    {

                    			markComposite(elementTypeProvider.getElements_EntityParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Entity_0=ruleEntity();

                    state._fsp--;


                    			current = this_Entity_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:98:3: this_Relationships_1= ruleRelationships
                    {

                    			markComposite(elementTypeProvider.getElements_RelationshipsParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_Relationships_1=ruleRelationships();

                    state._fsp--;


                    			current = this_Relationships_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:107:3: this_GenerationSetting_2= ruleGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getElements_GenerationSettingParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_GenerationSetting_2=ruleGenerationSetting();

                    state._fsp--;


                    			current = this_GenerationSetting_2;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElements"


    // $ANTLR start "entryRuleEntity"
    // PsiInternalJDL.g:119:1: entryRuleEntity returns [Boolean current=false] : iv_ruleEntity= ruleEntity EOF ;
    public final Boolean entryRuleEntity() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEntity = null;


        try {
            // PsiInternalJDL.g:119:48: (iv_ruleEntity= ruleEntity EOF )
            // PsiInternalJDL.g:120:2: iv_ruleEntity= ruleEntity EOF
            {
             markComposite(elementTypeProvider.getEntityElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // PsiInternalJDL.g:126:1: ruleEntity returns [Boolean current=false] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) ;
    public final Boolean ruleEntity() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Boolean lv_fields_3_0 = null;

        Boolean lv_fields_5_0 = null;


        try {
            // PsiInternalJDL.g:127:1: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' ) )
            // PsiInternalJDL.g:128:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            {
            // PsiInternalJDL.g:128:2: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}' )
            // PsiInternalJDL.g:129:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fields_3_0= ruleField ) ) (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getEntity_EntityKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:136:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:137:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:137:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:138:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEntity_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEntity_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:160:3: ( (lv_fields_3_0= ruleField ) )
            // PsiInternalJDL.g:161:4: (lv_fields_3_0= ruleField )
            {
            // PsiInternalJDL.g:161:4: (lv_fields_3_0= ruleField )
            // PsiInternalJDL.g:162:5: lv_fields_3_0= ruleField
            {

            					markComposite(elementTypeProvider.getEntity_FieldsFieldParserRuleCall_3_0ElementType());
            				
            pushFollow(FOLLOW_6);
            lv_fields_3_0=ruleField();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:175:3: (otherlv_4= ',' ( (lv_fields_5_0= ruleField ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalJDL.g:176:4: otherlv_4= ',' ( (lv_fields_5_0= ruleField ) )
            	    {

            	    				markLeaf(elementTypeProvider.getEntity_CommaKeyword_4_0ElementType());
            	    			
            	    otherlv_4=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_4);
            	    			
            	    // PsiInternalJDL.g:183:4: ( (lv_fields_5_0= ruleField ) )
            	    // PsiInternalJDL.g:184:5: (lv_fields_5_0= ruleField )
            	    {
            	    // PsiInternalJDL.g:184:5: (lv_fields_5_0= ruleField )
            	    // PsiInternalJDL.g:185:6: lv_fields_5_0= ruleField
            	    {

            	    						markComposite(elementTypeProvider.getEntity_FieldsFieldParserRuleCall_4_1_0ElementType());
            	    					
            	    pushFollow(FOLLOW_6);
            	    lv_fields_5_0=ruleField();

            	    state._fsp--;


            	    						doneComposite();
            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getEntity_RightCurlyBracketKeyword_5ElementType());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleField"
    // PsiInternalJDL.g:210:1: entryRuleField returns [Boolean current=false] : iv_ruleField= ruleField EOF ;
    public final Boolean entryRuleField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleField = null;


        try {
            // PsiInternalJDL.g:210:47: (iv_ruleField= ruleField EOF )
            // PsiInternalJDL.g:211:2: iv_ruleField= ruleField EOF
            {
             markComposite(elementTypeProvider.getFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleField=ruleField();

            state._fsp--;

             current =iv_ruleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField"


    // $ANTLR start "ruleField"
    // PsiInternalJDL.g:217:1: ruleField returns [Boolean current=false] : (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) ;
    public final Boolean ruleField() throws RecognitionException {
        Boolean current = false;

        Boolean this_StringField_0 = null;

        Boolean this_NumericField_1 = null;

        Boolean this_BooleanField_2 = null;

        Boolean this_DateField_3 = null;

        Boolean this_BinaryLargeObjectField_4 = null;

        Boolean this_EnumField_5 = null;


        try {
            // PsiInternalJDL.g:218:1: ( (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField ) )
            // PsiInternalJDL.g:219:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            {
            // PsiInternalJDL.g:219:2: (this_StringField_0= ruleStringField | this_NumericField_1= ruleNumericField | this_BooleanField_2= ruleBooleanField | this_DateField_3= ruleDateField | this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField | this_EnumField_5= ruleEnumField )
            int alt4=6;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 21:
                    {
                    alt4=3;
                    }
                    break;
                case 24:
                case 25:
                case 26:
                    {
                    alt4=5;
                    }
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    {
                    alt4=2;
                    }
                    break;
                case 22:
                case 23:
                    {
                    alt4=4;
                    }
                    break;
                case EOF:
                case 13:
                case 14:
                    {
                    alt4=6;
                    }
                    break;
                case 15:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalJDL.g:220:3: this_StringField_0= ruleStringField
                    {

                    			markComposite(elementTypeProvider.getField_StringFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringField_0=ruleStringField();

                    state._fsp--;


                    			current = this_StringField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:229:3: this_NumericField_1= ruleNumericField
                    {

                    			markComposite(elementTypeProvider.getField_NumericFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumericField_1=ruleNumericField();

                    state._fsp--;


                    			current = this_NumericField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:238:3: this_BooleanField_2= ruleBooleanField
                    {

                    			markComposite(elementTypeProvider.getField_BooleanFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanField_2=ruleBooleanField();

                    state._fsp--;


                    			current = this_BooleanField_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:247:3: this_DateField_3= ruleDateField
                    {

                    			markComposite(elementTypeProvider.getField_DateFieldParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DateField_3=ruleDateField();

                    state._fsp--;


                    			current = this_DateField_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:256:3: this_BinaryLargeObjectField_4= ruleBinaryLargeObjectField
                    {

                    			markComposite(elementTypeProvider.getField_BinaryLargeObjectFieldParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BinaryLargeObjectField_4=ruleBinaryLargeObjectField();

                    state._fsp--;


                    			current = this_BinaryLargeObjectField_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalJDL.g:265:3: this_EnumField_5= ruleEnumField
                    {

                    			markComposite(elementTypeProvider.getField_EnumFieldParserRuleCall_5ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnumField_5=ruleEnumField();

                    state._fsp--;


                    			current = this_EnumField_5;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField"


    // $ANTLR start "entryRuleEnumField"
    // PsiInternalJDL.g:277:1: entryRuleEnumField returns [Boolean current=false] : iv_ruleEnumField= ruleEnumField EOF ;
    public final Boolean entryRuleEnumField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEnumField = null;


        try {
            // PsiInternalJDL.g:277:51: (iv_ruleEnumField= ruleEnumField EOF )
            // PsiInternalJDL.g:278:2: iv_ruleEnumField= ruleEnumField EOF
            {
             markComposite(elementTypeProvider.getEnumFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumField=ruleEnumField();

            state._fsp--;

             current =iv_ruleEnumField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumField"


    // $ANTLR start "ruleEnumField"
    // PsiInternalJDL.g:284:1: ruleEnumField returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleEnumField() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalJDL.g:285:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalJDL.g:286:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalJDL.g:286:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalJDL.g:287:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalJDL.g:287:3: (otherlv_0= RULE_ID )
            // PsiInternalJDL.g:288:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getEnumField_EnumTypeEnumTypeCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumField"


    // $ANTLR start "entryRuleStringField"
    // PsiInternalJDL.g:306:1: entryRuleStringField returns [Boolean current=false] : iv_ruleStringField= ruleStringField EOF ;
    public final Boolean entryRuleStringField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStringField = null;


        try {
            // PsiInternalJDL.g:306:53: (iv_ruleStringField= ruleStringField EOF )
            // PsiInternalJDL.g:307:2: iv_ruleStringField= ruleStringField EOF
            {
             markComposite(elementTypeProvider.getStringFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringField=ruleStringField();

            state._fsp--;

             current =iv_ruleStringField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringField"


    // $ANTLR start "ruleStringField"
    // PsiInternalJDL.g:313:1: ruleStringField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) ;
    public final Boolean ruleStringField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:314:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? ) )
            // PsiInternalJDL.g:315:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            {
            // PsiInternalJDL.g:315:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )? )
            // PsiInternalJDL.g:316:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'String' ( (lv_validators_2_0= ruleStringValidators ) )?
            {
            // PsiInternalJDL.g:316:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:317:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:317:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:318:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getStringField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getStringField_StringKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,15,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:340:3: ( (lv_validators_2_0= ruleStringValidators ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalJDL.g:341:4: (lv_validators_2_0= ruleStringValidators )
                    {
                    // PsiInternalJDL.g:341:4: (lv_validators_2_0= ruleStringValidators )
                    // PsiInternalJDL.g:342:5: lv_validators_2_0= ruleStringValidators
                    {

                    					markComposite(elementTypeProvider.getStringField_ValidatorsStringValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleStringValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringField"


    // $ANTLR start "entryRuleNumericField"
    // PsiInternalJDL.g:359:1: entryRuleNumericField returns [Boolean current=false] : iv_ruleNumericField= ruleNumericField EOF ;
    public final Boolean entryRuleNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumericField = null;


        try {
            // PsiInternalJDL.g:359:54: (iv_ruleNumericField= ruleNumericField EOF )
            // PsiInternalJDL.g:360:2: iv_ruleNumericField= ruleNumericField EOF
            {
             markComposite(elementTypeProvider.getNumericFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericField=ruleNumericField();

            state._fsp--;

             current =iv_ruleNumericField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericField"


    // $ANTLR start "ruleNumericField"
    // PsiInternalJDL.g:366:1: ruleNumericField returns [Boolean current=false] : (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) ;
    public final Boolean ruleNumericField() throws RecognitionException {
        Boolean current = false;

        Boolean this_IntegerField_0 = null;

        Boolean this_LongField_1 = null;

        Boolean this_BigDecimalField_2 = null;

        Boolean this_FloatField_3 = null;

        Boolean this_DoubleField_4 = null;


        try {
            // PsiInternalJDL.g:367:1: ( (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField ) )
            // PsiInternalJDL.g:368:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            {
            // PsiInternalJDL.g:368:2: (this_IntegerField_0= ruleIntegerField | this_LongField_1= ruleLongField | this_BigDecimalField_2= ruleBigDecimalField | this_FloatField_3= ruleFloatField | this_DoubleField_4= ruleDoubleField )
            int alt6=5;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 17:
                    {
                    alt6=2;
                    }
                    break;
                case 16:
                    {
                    alt6=1;
                    }
                    break;
                case 20:
                    {
                    alt6=5;
                    }
                    break;
                case 19:
                    {
                    alt6=4;
                    }
                    break;
                case 18:
                    {
                    alt6=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // PsiInternalJDL.g:369:3: this_IntegerField_0= ruleIntegerField
                    {

                    			markComposite(elementTypeProvider.getNumericField_IntegerFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerField_0=ruleIntegerField();

                    state._fsp--;


                    			current = this_IntegerField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:378:3: this_LongField_1= ruleLongField
                    {

                    			markComposite(elementTypeProvider.getNumericField_LongFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongField_1=ruleLongField();

                    state._fsp--;


                    			current = this_LongField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:387:3: this_BigDecimalField_2= ruleBigDecimalField
                    {

                    			markComposite(elementTypeProvider.getNumericField_BigDecimalFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BigDecimalField_2=ruleBigDecimalField();

                    state._fsp--;


                    			current = this_BigDecimalField_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:396:3: this_FloatField_3= ruleFloatField
                    {

                    			markComposite(elementTypeProvider.getNumericField_FloatFieldParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatField_3=ruleFloatField();

                    state._fsp--;


                    			current = this_FloatField_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalJDL.g:405:3: this_DoubleField_4= ruleDoubleField
                    {

                    			markComposite(elementTypeProvider.getNumericField_DoubleFieldParserRuleCall_4ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DoubleField_4=ruleDoubleField();

                    state._fsp--;


                    			current = this_DoubleField_4;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericField"


    // $ANTLR start "entryRuleIntegerField"
    // PsiInternalJDL.g:417:1: entryRuleIntegerField returns [Boolean current=false] : iv_ruleIntegerField= ruleIntegerField EOF ;
    public final Boolean entryRuleIntegerField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIntegerField = null;


        try {
            // PsiInternalJDL.g:417:54: (iv_ruleIntegerField= ruleIntegerField EOF )
            // PsiInternalJDL.g:418:2: iv_ruleIntegerField= ruleIntegerField EOF
            {
             markComposite(elementTypeProvider.getIntegerFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerField=ruleIntegerField();

            state._fsp--;

             current =iv_ruleIntegerField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerField"


    // $ANTLR start "ruleIntegerField"
    // PsiInternalJDL.g:424:1: ruleIntegerField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleIntegerField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:425:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:426:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:427:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Integer' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:427:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:428:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:428:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:429:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getIntegerField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getIntegerField_IntegerKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,16,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:451:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==27) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalJDL.g:452:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:452:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:453:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getIntegerField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerField"


    // $ANTLR start "entryRuleLongField"
    // PsiInternalJDL.g:470:1: entryRuleLongField returns [Boolean current=false] : iv_ruleLongField= ruleLongField EOF ;
    public final Boolean entryRuleLongField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLongField = null;


        try {
            // PsiInternalJDL.g:470:51: (iv_ruleLongField= ruleLongField EOF )
            // PsiInternalJDL.g:471:2: iv_ruleLongField= ruleLongField EOF
            {
             markComposite(elementTypeProvider.getLongFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongField=ruleLongField();

            state._fsp--;

             current =iv_ruleLongField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongField"


    // $ANTLR start "ruleLongField"
    // PsiInternalJDL.g:477:1: ruleLongField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleLongField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:478:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:480:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Long' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:480:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:481:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:481:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:482:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLongField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getLongField_LongKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,17,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:504:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==27) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalJDL.g:505:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:505:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:506:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getLongField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongField"


    // $ANTLR start "entryRuleBigDecimalField"
    // PsiInternalJDL.g:523:1: entryRuleBigDecimalField returns [Boolean current=false] : iv_ruleBigDecimalField= ruleBigDecimalField EOF ;
    public final Boolean entryRuleBigDecimalField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBigDecimalField = null;


        try {
            // PsiInternalJDL.g:523:57: (iv_ruleBigDecimalField= ruleBigDecimalField EOF )
            // PsiInternalJDL.g:524:2: iv_ruleBigDecimalField= ruleBigDecimalField EOF
            {
             markComposite(elementTypeProvider.getBigDecimalFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBigDecimalField=ruleBigDecimalField();

            state._fsp--;

             current =iv_ruleBigDecimalField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBigDecimalField"


    // $ANTLR start "ruleBigDecimalField"
    // PsiInternalJDL.g:530:1: ruleBigDecimalField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleBigDecimalField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:531:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:532:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:532:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:533:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'BigDecimal' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:533:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:534:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:534:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:535:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBigDecimalField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBigDecimalField_BigDecimalKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:557:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalJDL.g:558:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:558:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:559:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getBigDecimalField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBigDecimalField"


    // $ANTLR start "entryRuleFloatField"
    // PsiInternalJDL.g:576:1: entryRuleFloatField returns [Boolean current=false] : iv_ruleFloatField= ruleFloatField EOF ;
    public final Boolean entryRuleFloatField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFloatField = null;


        try {
            // PsiInternalJDL.g:576:52: (iv_ruleFloatField= ruleFloatField EOF )
            // PsiInternalJDL.g:577:2: iv_ruleFloatField= ruleFloatField EOF
            {
             markComposite(elementTypeProvider.getFloatFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatField=ruleFloatField();

            state._fsp--;

             current =iv_ruleFloatField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatField"


    // $ANTLR start "ruleFloatField"
    // PsiInternalJDL.g:583:1: ruleFloatField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleFloatField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:584:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:585:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:585:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:586:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Float' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:586:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:587:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:587:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:588:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFloatField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getFloatField_FloatKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:610:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalJDL.g:611:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:611:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:612:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getFloatField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatField"


    // $ANTLR start "entryRuleDoubleField"
    // PsiInternalJDL.g:629:1: entryRuleDoubleField returns [Boolean current=false] : iv_ruleDoubleField= ruleDoubleField EOF ;
    public final Boolean entryRuleDoubleField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDoubleField = null;


        try {
            // PsiInternalJDL.g:629:53: (iv_ruleDoubleField= ruleDoubleField EOF )
            // PsiInternalJDL.g:630:2: iv_ruleDoubleField= ruleDoubleField EOF
            {
             markComposite(elementTypeProvider.getDoubleFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDoubleField=ruleDoubleField();

            state._fsp--;

             current =iv_ruleDoubleField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleField"


    // $ANTLR start "ruleDoubleField"
    // PsiInternalJDL.g:636:1: ruleDoubleField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) ;
    public final Boolean ruleDoubleField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:637:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? ) )
            // PsiInternalJDL.g:638:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            {
            // PsiInternalJDL.g:638:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )? )
            // PsiInternalJDL.g:639:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Double' ( (lv_validators_2_0= ruleNumericValidators ) )?
            {
            // PsiInternalJDL.g:639:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:640:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:640:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:641:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDoubleField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getDoubleField_DoubleKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:663:3: ( (lv_validators_2_0= ruleNumericValidators ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalJDL.g:664:4: (lv_validators_2_0= ruleNumericValidators )
                    {
                    // PsiInternalJDL.g:664:4: (lv_validators_2_0= ruleNumericValidators )
                    // PsiInternalJDL.g:665:5: lv_validators_2_0= ruleNumericValidators
                    {

                    					markComposite(elementTypeProvider.getDoubleField_ValidatorsNumericValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleNumericValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleField"


    // $ANTLR start "entryRuleBooleanField"
    // PsiInternalJDL.g:682:1: entryRuleBooleanField returns [Boolean current=false] : iv_ruleBooleanField= ruleBooleanField EOF ;
    public final Boolean entryRuleBooleanField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBooleanField = null;


        try {
            // PsiInternalJDL.g:682:54: (iv_ruleBooleanField= ruleBooleanField EOF )
            // PsiInternalJDL.g:683:2: iv_ruleBooleanField= ruleBooleanField EOF
            {
             markComposite(elementTypeProvider.getBooleanFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanField=ruleBooleanField();

            state._fsp--;

             current =iv_ruleBooleanField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanField"


    // $ANTLR start "ruleBooleanField"
    // PsiInternalJDL.g:689:1: ruleBooleanField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleBooleanField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:690:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:691:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:691:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:692:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Boolean' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:692:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:693:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:693:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:694:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBooleanField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBooleanField_BooleanKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:716:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PsiInternalJDL.g:717:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:717:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:718:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getBooleanField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanField"


    // $ANTLR start "entryRuleDateField"
    // PsiInternalJDL.g:735:1: entryRuleDateField returns [Boolean current=false] : iv_ruleDateField= ruleDateField EOF ;
    public final Boolean entryRuleDateField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDateField = null;


        try {
            // PsiInternalJDL.g:735:51: (iv_ruleDateField= ruleDateField EOF )
            // PsiInternalJDL.g:736:2: iv_ruleDateField= ruleDateField EOF
            {
             markComposite(elementTypeProvider.getDateFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateField=ruleDateField();

            state._fsp--;

             current =iv_ruleDateField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDateField"


    // $ANTLR start "ruleDateField"
    // PsiInternalJDL.g:742:1: ruleDateField returns [Boolean current=false] : (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) ;
    public final Boolean ruleDateField() throws RecognitionException {
        Boolean current = false;

        Boolean this_LocalDateField_0 = null;

        Boolean this_ZonedDateTimeField_1 = null;


        try {
            // PsiInternalJDL.g:743:1: ( (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField ) )
            // PsiInternalJDL.g:744:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            {
            // PsiInternalJDL.g:744:2: (this_LocalDateField_0= ruleLocalDateField | this_ZonedDateTimeField_1= ruleZonedDateTimeField )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==23) ) {
                    alt13=2;
                }
                else if ( (LA13_1==22) ) {
                    alt13=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // PsiInternalJDL.g:745:3: this_LocalDateField_0= ruleLocalDateField
                    {

                    			markComposite(elementTypeProvider.getDateField_LocalDateFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_LocalDateField_0=ruleLocalDateField();

                    state._fsp--;


                    			current = this_LocalDateField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:754:3: this_ZonedDateTimeField_1= ruleZonedDateTimeField
                    {

                    			markComposite(elementTypeProvider.getDateField_ZonedDateTimeFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ZonedDateTimeField_1=ruleZonedDateTimeField();

                    state._fsp--;


                    			current = this_ZonedDateTimeField_1;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDateField"


    // $ANTLR start "entryRuleLocalDateField"
    // PsiInternalJDL.g:766:1: entryRuleLocalDateField returns [Boolean current=false] : iv_ruleLocalDateField= ruleLocalDateField EOF ;
    public final Boolean entryRuleLocalDateField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLocalDateField = null;


        try {
            // PsiInternalJDL.g:766:56: (iv_ruleLocalDateField= ruleLocalDateField EOF )
            // PsiInternalJDL.g:767:2: iv_ruleLocalDateField= ruleLocalDateField EOF
            {
             markComposite(elementTypeProvider.getLocalDateFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalDateField=ruleLocalDateField();

            state._fsp--;

             current =iv_ruleLocalDateField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalDateField"


    // $ANTLR start "ruleLocalDateField"
    // PsiInternalJDL.g:773:1: ruleLocalDateField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleLocalDateField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:774:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:775:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:775:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:776:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'LocalDate' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:776:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:777:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:777:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:778:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLocalDateField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getLocalDateField_LocalDateKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,22,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:800:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PsiInternalJDL.g:801:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:801:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:802:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getLocalDateField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalDateField"


    // $ANTLR start "entryRuleZonedDateTimeField"
    // PsiInternalJDL.g:819:1: entryRuleZonedDateTimeField returns [Boolean current=false] : iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF ;
    public final Boolean entryRuleZonedDateTimeField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleZonedDateTimeField = null;


        try {
            // PsiInternalJDL.g:819:60: (iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF )
            // PsiInternalJDL.g:820:2: iv_ruleZonedDateTimeField= ruleZonedDateTimeField EOF
            {
             markComposite(elementTypeProvider.getZonedDateTimeFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleZonedDateTimeField=ruleZonedDateTimeField();

            state._fsp--;

             current =iv_ruleZonedDateTimeField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleZonedDateTimeField"


    // $ANTLR start "ruleZonedDateTimeField"
    // PsiInternalJDL.g:826:1: ruleZonedDateTimeField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) ;
    public final Boolean ruleZonedDateTimeField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:827:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? ) )
            // PsiInternalJDL.g:828:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            {
            // PsiInternalJDL.g:828:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )? )
            // PsiInternalJDL.g:829:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ZonedDateTime' ( (lv_validators_2_0= ruleRequiredValidator ) )?
            {
            // PsiInternalJDL.g:829:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:830:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:830:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:831:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getZonedDateTimeField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getZonedDateTimeField_ZonedDateTimeKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,23,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:853:3: ( (lv_validators_2_0= ruleRequiredValidator ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalJDL.g:854:4: (lv_validators_2_0= ruleRequiredValidator )
                    {
                    // PsiInternalJDL.g:854:4: (lv_validators_2_0= ruleRequiredValidator )
                    // PsiInternalJDL.g:855:5: lv_validators_2_0= ruleRequiredValidator
                    {

                    					markComposite(elementTypeProvider.getZonedDateTimeField_ValidatorsRequiredValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleRequiredValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleZonedDateTimeField"


    // $ANTLR start "entryRuleBinaryLargeObjectField"
    // PsiInternalJDL.g:872:1: entryRuleBinaryLargeObjectField returns [Boolean current=false] : iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF ;
    public final Boolean entryRuleBinaryLargeObjectField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBinaryLargeObjectField = null;


        try {
            // PsiInternalJDL.g:872:64: (iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF )
            // PsiInternalJDL.g:873:2: iv_ruleBinaryLargeObjectField= ruleBinaryLargeObjectField EOF
            {
             markComposite(elementTypeProvider.getBinaryLargeObjectFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryLargeObjectField=ruleBinaryLargeObjectField();

            state._fsp--;

             current =iv_ruleBinaryLargeObjectField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryLargeObjectField"


    // $ANTLR start "ruleBinaryLargeObjectField"
    // PsiInternalJDL.g:879:1: ruleBinaryLargeObjectField returns [Boolean current=false] : (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) ;
    public final Boolean ruleBinaryLargeObjectField() throws RecognitionException {
        Boolean current = false;

        Boolean this_BlobField_0 = null;

        Boolean this_AnyBlobField_1 = null;

        Boolean this_ImageBlobField_2 = null;


        try {
            // PsiInternalJDL.g:880:1: ( (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField ) )
            // PsiInternalJDL.g:881:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            {
            // PsiInternalJDL.g:881:2: (this_BlobField_0= ruleBlobField | this_AnyBlobField_1= ruleAnyBlobField | this_ImageBlobField_2= ruleImageBlobField )
            int alt16=3;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 25:
                    {
                    alt16=2;
                    }
                    break;
                case 24:
                    {
                    alt16=1;
                    }
                    break;
                case 26:
                    {
                    alt16=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalJDL.g:882:3: this_BlobField_0= ruleBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_BlobFieldParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_BlobField_0=ruleBlobField();

                    state._fsp--;


                    			current = this_BlobField_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:891:3: this_AnyBlobField_1= ruleAnyBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_AnyBlobFieldParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_AnyBlobField_1=ruleAnyBlobField();

                    state._fsp--;


                    			current = this_AnyBlobField_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:900:3: this_ImageBlobField_2= ruleImageBlobField
                    {

                    			markComposite(elementTypeProvider.getBinaryLargeObjectField_ImageBlobFieldParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ImageBlobField_2=ruleImageBlobField();

                    state._fsp--;


                    			current = this_ImageBlobField_2;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryLargeObjectField"


    // $ANTLR start "entryRuleBlobField"
    // PsiInternalJDL.g:912:1: entryRuleBlobField returns [Boolean current=false] : iv_ruleBlobField= ruleBlobField EOF ;
    public final Boolean entryRuleBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBlobField = null;


        try {
            // PsiInternalJDL.g:912:51: (iv_ruleBlobField= ruleBlobField EOF )
            // PsiInternalJDL.g:913:2: iv_ruleBlobField= ruleBlobField EOF
            {
             markComposite(elementTypeProvider.getBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobField=ruleBlobField();

            state._fsp--;

             current =iv_ruleBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlobField"


    // $ANTLR start "ruleBlobField"
    // PsiInternalJDL.g:919:1: ruleBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:920:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:921:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:921:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:922:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'Blob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:922:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:923:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:923:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:924:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBlobField_BlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,24,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:946:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalJDL.g:947:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:947:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:948:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlobField"


    // $ANTLR start "entryRuleAnyBlobField"
    // PsiInternalJDL.g:965:1: entryRuleAnyBlobField returns [Boolean current=false] : iv_ruleAnyBlobField= ruleAnyBlobField EOF ;
    public final Boolean entryRuleAnyBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAnyBlobField = null;


        try {
            // PsiInternalJDL.g:965:54: (iv_ruleAnyBlobField= ruleAnyBlobField EOF )
            // PsiInternalJDL.g:966:2: iv_ruleAnyBlobField= ruleAnyBlobField EOF
            {
             markComposite(elementTypeProvider.getAnyBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnyBlobField=ruleAnyBlobField();

            state._fsp--;

             current =iv_ruleAnyBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnyBlobField"


    // $ANTLR start "ruleAnyBlobField"
    // PsiInternalJDL.g:972:1: ruleAnyBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleAnyBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:973:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:974:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:974:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:975:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'AnyBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:975:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:976:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:976:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:977:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAnyBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getAnyBlobField_AnyBlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,25,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:999:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // PsiInternalJDL.g:1000:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:1000:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:1001:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getAnyBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnyBlobField"


    // $ANTLR start "entryRuleImageBlobField"
    // PsiInternalJDL.g:1018:1: entryRuleImageBlobField returns [Boolean current=false] : iv_ruleImageBlobField= ruleImageBlobField EOF ;
    public final Boolean entryRuleImageBlobField() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImageBlobField = null;


        try {
            // PsiInternalJDL.g:1018:56: (iv_ruleImageBlobField= ruleImageBlobField EOF )
            // PsiInternalJDL.g:1019:2: iv_ruleImageBlobField= ruleImageBlobField EOF
            {
             markComposite(elementTypeProvider.getImageBlobFieldElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleImageBlobField=ruleImageBlobField();

            state._fsp--;

             current =iv_ruleImageBlobField; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImageBlobField"


    // $ANTLR start "ruleImageBlobField"
    // PsiInternalJDL.g:1025:1: ruleImageBlobField returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) ;
    public final Boolean ruleImageBlobField() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Boolean lv_validators_2_0 = null;


        try {
            // PsiInternalJDL.g:1026:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? ) )
            // PsiInternalJDL.g:1027:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            {
            // PsiInternalJDL.g:1027:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )? )
            // PsiInternalJDL.g:1028:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= 'ImageBlob' ( (lv_validators_2_0= ruleBlobValidators ) )?
            {
            // PsiInternalJDL.g:1028:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalJDL.g:1029:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalJDL.g:1029:4: (lv_name_0_0= RULE_ID )
            // PsiInternalJDL.g:1030:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getImageBlobField_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getImageBlobField_ImageBlobKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,26,FOLLOW_8); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1052:3: ( (lv_validators_2_0= ruleBlobValidators ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalJDL.g:1053:4: (lv_validators_2_0= ruleBlobValidators )
                    {
                    // PsiInternalJDL.g:1053:4: (lv_validators_2_0= ruleBlobValidators )
                    // PsiInternalJDL.g:1054:5: lv_validators_2_0= ruleBlobValidators
                    {

                    					markComposite(elementTypeProvider.getImageBlobField_ValidatorsBlobValidatorsParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_validators_2_0=ruleBlobValidators();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImageBlobField"


    // $ANTLR start "entryRuleRequiredValidator"
    // PsiInternalJDL.g:1071:1: entryRuleRequiredValidator returns [Boolean current=false] : iv_ruleRequiredValidator= ruleRequiredValidator EOF ;
    public final Boolean entryRuleRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRequiredValidator = null;


        try {
            // PsiInternalJDL.g:1071:59: (iv_ruleRequiredValidator= ruleRequiredValidator EOF )
            // PsiInternalJDL.g:1072:2: iv_ruleRequiredValidator= ruleRequiredValidator EOF
            {
             markComposite(elementTypeProvider.getRequiredValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequiredValidator=ruleRequiredValidator();

            state._fsp--;

             current =iv_ruleRequiredValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredValidator"


    // $ANTLR start "ruleRequiredValidator"
    // PsiInternalJDL.g:1078:1: ruleRequiredValidator returns [Boolean current=false] : ( (lv_required_0_0= 'required' ) ) ;
    public final Boolean ruleRequiredValidator() throws RecognitionException {
        Boolean current = false;

        Token lv_required_0_0=null;

        try {
            // PsiInternalJDL.g:1079:1: ( ( (lv_required_0_0= 'required' ) ) )
            // PsiInternalJDL.g:1080:2: ( (lv_required_0_0= 'required' ) )
            {
            // PsiInternalJDL.g:1080:2: ( (lv_required_0_0= 'required' ) )
            // PsiInternalJDL.g:1081:3: (lv_required_0_0= 'required' )
            {
            // PsiInternalJDL.g:1081:3: (lv_required_0_0= 'required' )
            // PsiInternalJDL.g:1082:4: lv_required_0_0= 'required'
            {

            				markLeaf(elementTypeProvider.getRequiredValidator_RequiredRequiredKeyword_0ElementType());
            			
            lv_required_0_0=(Token)match(input,27,FOLLOW_2); 

            				doneLeaf(lv_required_0_0);
            			

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequiredValidator"


    // $ANTLR start "entryRuleMinLengthValidator"
    // PsiInternalJDL.g:1100:1: entryRuleMinLengthValidator returns [Boolean current=false] : iv_ruleMinLengthValidator= ruleMinLengthValidator EOF ;
    public final Boolean entryRuleMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinLengthValidator = null;


        try {
            // PsiInternalJDL.g:1100:60: (iv_ruleMinLengthValidator= ruleMinLengthValidator EOF )
            // PsiInternalJDL.g:1101:2: iv_ruleMinLengthValidator= ruleMinLengthValidator EOF
            {
             markComposite(elementTypeProvider.getMinLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinLengthValidator=ruleMinLengthValidator();

            state._fsp--;

             current =iv_ruleMinLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinLengthValidator"


    // $ANTLR start "ruleMinLengthValidator"
    // PsiInternalJDL.g:1107:1: ruleMinLengthValidator returns [Boolean current=false] : (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1108:1: ( (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1109:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1109:2: (otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1110:3: otherlv_0= 'minlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinLengthValidator_MinlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1124:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1125:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1125:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1126:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinLengthValidator"


    // $ANTLR start "entryRuleMaxLengthValidator"
    // PsiInternalJDL.g:1152:1: entryRuleMaxLengthValidator returns [Boolean current=false] : iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF ;
    public final Boolean entryRuleMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxLengthValidator = null;


        try {
            // PsiInternalJDL.g:1152:60: (iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF )
            // PsiInternalJDL.g:1153:2: iv_ruleMaxLengthValidator= ruleMaxLengthValidator EOF
            {
             markComposite(elementTypeProvider.getMaxLengthValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxLengthValidator=ruleMaxLengthValidator();

            state._fsp--;

             current =iv_ruleMaxLengthValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxLengthValidator"


    // $ANTLR start "ruleMaxLengthValidator"
    // PsiInternalJDL.g:1159:1: ruleMaxLengthValidator returns [Boolean current=false] : (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxLengthValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1160:1: ( (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1161:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1161:2: (otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1162:3: otherlv_0= 'maxlength' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxLengthValidator_MaxlengthKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxLengthValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1176:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1177:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1177:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1178:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxLengthValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxLengthValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxLengthValidator"


    // $ANTLR start "entryRulePatternValidator"
    // PsiInternalJDL.g:1204:1: entryRulePatternValidator returns [Boolean current=false] : iv_rulePatternValidator= rulePatternValidator EOF ;
    public final Boolean entryRulePatternValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePatternValidator = null;


        try {
            // PsiInternalJDL.g:1204:58: (iv_rulePatternValidator= rulePatternValidator EOF )
            // PsiInternalJDL.g:1205:2: iv_rulePatternValidator= rulePatternValidator EOF
            {
             markComposite(elementTypeProvider.getPatternValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_rulePatternValidator=rulePatternValidator();

            state._fsp--;

             current =iv_rulePatternValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternValidator"


    // $ANTLR start "rulePatternValidator"
    // PsiInternalJDL.g:1211:1: rulePatternValidator returns [Boolean current=false] : (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) ;
    public final Boolean rulePatternValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1212:1: ( (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1213:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1213:2: (otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1214:3: otherlv_0= 'pattern' otherlv_1= '(' ( (lv_value_2_0= RULE_STRING ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getPatternValidator_PatternKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,32,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getPatternValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_23); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1228:3: ( (lv_value_2_0= RULE_STRING ) )
            // PsiInternalJDL.g:1229:4: (lv_value_2_0= RULE_STRING )
            {
            // PsiInternalJDL.g:1229:4: (lv_value_2_0= RULE_STRING )
            // PsiInternalJDL.g:1230:5: lv_value_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getPatternValidator_ValueSTRINGTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getPatternValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternValidator"


    // $ANTLR start "entryRuleMinValidator"
    // PsiInternalJDL.g:1256:1: entryRuleMinValidator returns [Boolean current=false] : iv_ruleMinValidator= ruleMinValidator EOF ;
    public final Boolean entryRuleMinValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinValidator = null;


        try {
            // PsiInternalJDL.g:1256:54: (iv_ruleMinValidator= ruleMinValidator EOF )
            // PsiInternalJDL.g:1257:2: iv_ruleMinValidator= ruleMinValidator EOF
            {
             markComposite(elementTypeProvider.getMinValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinValidator=ruleMinValidator();

            state._fsp--;

             current =iv_ruleMinValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinValidator"


    // $ANTLR start "ruleMinValidator"
    // PsiInternalJDL.g:1263:1: ruleMinValidator returns [Boolean current=false] : (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1264:1: ( (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1265:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1265:2: (otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1266:3: otherlv_0= 'min' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinValidator_MinKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,33,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1280:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1281:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1281:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1282:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinValidator"


    // $ANTLR start "entryRuleMaxValidator"
    // PsiInternalJDL.g:1308:1: entryRuleMaxValidator returns [Boolean current=false] : iv_ruleMaxValidator= ruleMaxValidator EOF ;
    public final Boolean entryRuleMaxValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxValidator = null;


        try {
            // PsiInternalJDL.g:1308:54: (iv_ruleMaxValidator= ruleMaxValidator EOF )
            // PsiInternalJDL.g:1309:2: iv_ruleMaxValidator= ruleMaxValidator EOF
            {
             markComposite(elementTypeProvider.getMaxValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxValidator=ruleMaxValidator();

            state._fsp--;

             current =iv_ruleMaxValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxValidator"


    // $ANTLR start "ruleMaxValidator"
    // PsiInternalJDL.g:1315:1: ruleMaxValidator returns [Boolean current=false] : (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1316:1: ( (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1317:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1317:2: (otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1318:3: otherlv_0= 'max' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxValidator_MaxKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1332:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1333:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1333:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1334:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxValidator"


    // $ANTLR start "entryRuleMinBytesValidator"
    // PsiInternalJDL.g:1360:1: entryRuleMinBytesValidator returns [Boolean current=false] : iv_ruleMinBytesValidator= ruleMinBytesValidator EOF ;
    public final Boolean entryRuleMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMinBytesValidator = null;


        try {
            // PsiInternalJDL.g:1360:59: (iv_ruleMinBytesValidator= ruleMinBytesValidator EOF )
            // PsiInternalJDL.g:1361:2: iv_ruleMinBytesValidator= ruleMinBytesValidator EOF
            {
             markComposite(elementTypeProvider.getMinBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinBytesValidator=ruleMinBytesValidator();

            state._fsp--;

             current =iv_ruleMinBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinBytesValidator"


    // $ANTLR start "ruleMinBytesValidator"
    // PsiInternalJDL.g:1367:1: ruleMinBytesValidator returns [Boolean current=false] : (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMinBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1368:1: ( (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1369:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1369:2: (otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1370:3: otherlv_0= 'minbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMinBytesValidator_MinbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMinBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1384:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1385:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1385:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1386:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMinBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMinBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinBytesValidator"


    // $ANTLR start "entryRuleMaxBytesValidator"
    // PsiInternalJDL.g:1412:1: entryRuleMaxBytesValidator returns [Boolean current=false] : iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF ;
    public final Boolean entryRuleMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMaxBytesValidator = null;


        try {
            // PsiInternalJDL.g:1412:59: (iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF )
            // PsiInternalJDL.g:1413:2: iv_ruleMaxBytesValidator= ruleMaxBytesValidator EOF
            {
             markComposite(elementTypeProvider.getMaxBytesValidatorElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleMaxBytesValidator=ruleMaxBytesValidator();

            state._fsp--;

             current =iv_ruleMaxBytesValidator; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxBytesValidator"


    // $ANTLR start "ruleMaxBytesValidator"
    // PsiInternalJDL.g:1419:1: ruleMaxBytesValidator returns [Boolean current=false] : (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) ;
    public final Boolean ruleMaxBytesValidator() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;
        Token otherlv_3=null;

        try {
            // PsiInternalJDL.g:1420:1: ( (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' ) )
            // PsiInternalJDL.g:1421:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            {
            // PsiInternalJDL.g:1421:2: (otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')' )
            // PsiInternalJDL.g:1422:3: otherlv_0= 'maxbytes' otherlv_1= '(' ( (lv_value_2_0= RULE_INT ) ) otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getMaxBytesValidator_MaxbytesKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,36,FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getMaxBytesValidator_LeftParenthesisKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,29,FOLLOW_21); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalJDL.g:1436:3: ( (lv_value_2_0= RULE_INT ) )
            // PsiInternalJDL.g:1437:4: (lv_value_2_0= RULE_INT )
            {
            // PsiInternalJDL.g:1437:4: (lv_value_2_0= RULE_INT )
            // PsiInternalJDL.g:1438:5: lv_value_2_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getMaxBytesValidator_ValueINTTerminalRuleCall_2_0ElementType());
            				
            lv_value_2_0=(Token)match(input,RULE_INT,FOLLOW_22); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_value_2_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMaxBytesValidator_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,30,FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxBytesValidator"


    // $ANTLR start "entryRuleStringValidators"
    // PsiInternalJDL.g:1464:1: entryRuleStringValidators returns [Boolean current=false] : iv_ruleStringValidators= ruleStringValidators EOF ;
    public final Boolean entryRuleStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStringValidators = null;


        try {
            // PsiInternalJDL.g:1464:58: (iv_ruleStringValidators= ruleStringValidators EOF )
            // PsiInternalJDL.g:1465:2: iv_ruleStringValidators= ruleStringValidators EOF
            {
             markComposite(elementTypeProvider.getStringValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValidators=ruleStringValidators();

            state._fsp--;

             current =iv_ruleStringValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValidators"


    // $ANTLR start "ruleStringValidators"
    // PsiInternalJDL.g:1471:1: ruleStringValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) ;
    public final Boolean ruleStringValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minLength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;

        Boolean lv_pattern_3_0 = null;


        try {
            // PsiInternalJDL.g:1472:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? ) )
            // PsiInternalJDL.g:1473:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            {
            // PsiInternalJDL.g:1473:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )? )
            // PsiInternalJDL.g:1474:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minLength_1_0= ruleMinLengthValidator ) )? ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )? ( (lv_pattern_3_0= rulePatternValidator ) )?
            {
            // PsiInternalJDL.g:1474:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1475:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1475:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1476:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getStringValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_24);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1489:3: ( (lv_minLength_1_0= ruleMinLengthValidator ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // PsiInternalJDL.g:1490:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    {
                    // PsiInternalJDL.g:1490:4: (lv_minLength_1_0= ruleMinLengthValidator )
                    // PsiInternalJDL.g:1491:5: lv_minLength_1_0= ruleMinLengthValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_MinLengthMinLengthValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_25);
                    lv_minLength_1_0=ruleMinLengthValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:1504:3: ( (lv_maxlength_2_0= ruleMaxLengthValidator ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalJDL.g:1505:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    {
                    // PsiInternalJDL.g:1505:4: (lv_maxlength_2_0= ruleMaxLengthValidator )
                    // PsiInternalJDL.g:1506:5: lv_maxlength_2_0= ruleMaxLengthValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_MaxlengthMaxLengthValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_26);
                    lv_maxlength_2_0=ruleMaxLengthValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:1519:3: ( (lv_pattern_3_0= rulePatternValidator ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // PsiInternalJDL.g:1520:4: (lv_pattern_3_0= rulePatternValidator )
                    {
                    // PsiInternalJDL.g:1520:4: (lv_pattern_3_0= rulePatternValidator )
                    // PsiInternalJDL.g:1521:5: lv_pattern_3_0= rulePatternValidator
                    {

                    					markComposite(elementTypeProvider.getStringValidators_PatternPatternValidatorParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pattern_3_0=rulePatternValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValidators"


    // $ANTLR start "entryRuleNumericValidators"
    // PsiInternalJDL.g:1538:1: entryRuleNumericValidators returns [Boolean current=false] : iv_ruleNumericValidators= ruleNumericValidators EOF ;
    public final Boolean entryRuleNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNumericValidators = null;


        try {
            // PsiInternalJDL.g:1538:59: (iv_ruleNumericValidators= ruleNumericValidators EOF )
            // PsiInternalJDL.g:1539:2: iv_ruleNumericValidators= ruleNumericValidators EOF
            {
             markComposite(elementTypeProvider.getNumericValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericValidators=ruleNumericValidators();

            state._fsp--;

             current =iv_ruleNumericValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericValidators"


    // $ANTLR start "ruleNumericValidators"
    // PsiInternalJDL.g:1545:1: ruleNumericValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) ;
    public final Boolean ruleNumericValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minlength_1_0 = null;

        Boolean lv_maxlength_2_0 = null;


        try {
            // PsiInternalJDL.g:1546:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? ) )
            // PsiInternalJDL.g:1547:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            {
            // PsiInternalJDL.g:1547:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )? )
            // PsiInternalJDL.g:1548:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minlength_1_0= ruleMinValidator ) )? ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            {
            // PsiInternalJDL.g:1548:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1549:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1549:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1550:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getNumericValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_27);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1563:3: ( (lv_minlength_1_0= ruleMinValidator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // PsiInternalJDL.g:1564:4: (lv_minlength_1_0= ruleMinValidator )
                    {
                    // PsiInternalJDL.g:1564:4: (lv_minlength_1_0= ruleMinValidator )
                    // PsiInternalJDL.g:1565:5: lv_minlength_1_0= ruleMinValidator
                    {

                    					markComposite(elementTypeProvider.getNumericValidators_MinlengthMinValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_28);
                    lv_minlength_1_0=ruleMinValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:1578:3: ( (lv_maxlength_2_0= ruleMaxValidator ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // PsiInternalJDL.g:1579:4: (lv_maxlength_2_0= ruleMaxValidator )
                    {
                    // PsiInternalJDL.g:1579:4: (lv_maxlength_2_0= ruleMaxValidator )
                    // PsiInternalJDL.g:1580:5: lv_maxlength_2_0= ruleMaxValidator
                    {

                    					markComposite(elementTypeProvider.getNumericValidators_MaxlengthMaxValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxlength_2_0=ruleMaxValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericValidators"


    // $ANTLR start "entryRuleBlobValidators"
    // PsiInternalJDL.g:1597:1: entryRuleBlobValidators returns [Boolean current=false] : iv_ruleBlobValidators= ruleBlobValidators EOF ;
    public final Boolean entryRuleBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBlobValidators = null;


        try {
            // PsiInternalJDL.g:1597:56: (iv_ruleBlobValidators= ruleBlobValidators EOF )
            // PsiInternalJDL.g:1598:2: iv_ruleBlobValidators= ruleBlobValidators EOF
            {
             markComposite(elementTypeProvider.getBlobValidatorsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlobValidators=ruleBlobValidators();

            state._fsp--;

             current =iv_ruleBlobValidators; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlobValidators"


    // $ANTLR start "ruleBlobValidators"
    // PsiInternalJDL.g:1604:1: ruleBlobValidators returns [Boolean current=false] : ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) ;
    public final Boolean ruleBlobValidators() throws RecognitionException {
        Boolean current = false;

        Boolean lv_required_0_0 = null;

        Boolean lv_minbytes_1_0 = null;

        Boolean lv_maxbytes_2_0 = null;


        try {
            // PsiInternalJDL.g:1605:1: ( ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? ) )
            // PsiInternalJDL.g:1606:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            {
            // PsiInternalJDL.g:1606:2: ( ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )? )
            // PsiInternalJDL.g:1607:3: ( (lv_required_0_0= ruleRequiredValidator ) ) ( (lv_minbytes_1_0= ruleMinBytesValidator ) )? ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            {
            // PsiInternalJDL.g:1607:3: ( (lv_required_0_0= ruleRequiredValidator ) )
            // PsiInternalJDL.g:1608:4: (lv_required_0_0= ruleRequiredValidator )
            {
            // PsiInternalJDL.g:1608:4: (lv_required_0_0= ruleRequiredValidator )
            // PsiInternalJDL.g:1609:5: lv_required_0_0= ruleRequiredValidator
            {

            					markComposite(elementTypeProvider.getBlobValidators_RequiredRequiredValidatorParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_29);
            lv_required_0_0=ruleRequiredValidator();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1622:3: ( (lv_minbytes_1_0= ruleMinBytesValidator ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // PsiInternalJDL.g:1623:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    {
                    // PsiInternalJDL.g:1623:4: (lv_minbytes_1_0= ruleMinBytesValidator )
                    // PsiInternalJDL.g:1624:5: lv_minbytes_1_0= ruleMinBytesValidator
                    {

                    					markComposite(elementTypeProvider.getBlobValidators_MinbytesMinBytesValidatorParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_30);
                    lv_minbytes_1_0=ruleMinBytesValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }

            // PsiInternalJDL.g:1637:3: ( (lv_maxbytes_2_0= ruleMaxBytesValidator ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==36) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // PsiInternalJDL.g:1638:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    {
                    // PsiInternalJDL.g:1638:4: (lv_maxbytes_2_0= ruleMaxBytesValidator )
                    // PsiInternalJDL.g:1639:5: lv_maxbytes_2_0= ruleMaxBytesValidator
                    {

                    					markComposite(elementTypeProvider.getBlobValidators_MaxbytesMaxBytesValidatorParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_maxbytes_2_0=ruleMaxBytesValidator();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlobValidators"


    // $ANTLR start "entryRuleRelationships"
    // PsiInternalJDL.g:1656:1: entryRuleRelationships returns [Boolean current=false] : iv_ruleRelationships= ruleRelationships EOF ;
    public final Boolean entryRuleRelationships() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationships = null;


        try {
            // PsiInternalJDL.g:1656:55: (iv_ruleRelationships= ruleRelationships EOF )
            // PsiInternalJDL.g:1657:2: iv_ruleRelationships= ruleRelationships EOF
            {
             markComposite(elementTypeProvider.getRelationshipsElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationships=ruleRelationships();

            state._fsp--;

             current =iv_ruleRelationships; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationships"


    // $ANTLR start "ruleRelationships"
    // PsiInternalJDL.g:1663:1: ruleRelationships returns [Boolean current=false] : (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) ;
    public final Boolean ruleRelationships() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_cardinality_1_0 = null;

        Boolean lv_relationships_3_0 = null;


        try {
            // PsiInternalJDL.g:1664:1: ( (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' ) )
            // PsiInternalJDL.g:1665:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            {
            // PsiInternalJDL.g:1665:2: (otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}' )
            // PsiInternalJDL.g:1666:3: otherlv_0= 'relationship' ( (lv_cardinality_1_0= ruleCardinality ) ) otherlv_2= '{' ( (lv_relationships_3_0= ruleRelationship ) )* otherlv_4= '}'
            {

            			markLeaf(elementTypeProvider.getRelationships_RelationshipKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,37,FOLLOW_31); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1673:3: ( (lv_cardinality_1_0= ruleCardinality ) )
            // PsiInternalJDL.g:1674:4: (lv_cardinality_1_0= ruleCardinality )
            {
            // PsiInternalJDL.g:1674:4: (lv_cardinality_1_0= ruleCardinality )
            // PsiInternalJDL.g:1675:5: lv_cardinality_1_0= ruleCardinality
            {

            					markComposite(elementTypeProvider.getRelationships_CardinalityCardinalityEnumRuleCall_1_0ElementType());
            				
            pushFollow(FOLLOW_5);
            lv_cardinality_1_0=ruleCardinality();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getRelationships_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_32); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1695:3: ( (lv_relationships_3_0= ruleRelationship ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==11) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // PsiInternalJDL.g:1696:4: (lv_relationships_3_0= ruleRelationship )
            	    {
            	    // PsiInternalJDL.g:1696:4: (lv_relationships_3_0= ruleRelationship )
            	    // PsiInternalJDL.g:1697:5: lv_relationships_3_0= ruleRelationship
            	    {

            	    					markComposite(elementTypeProvider.getRelationships_RelationshipsRelationshipParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_relationships_3_0=ruleRelationship();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getRelationships_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationships"


    // $ANTLR start "entryRuleRelationship"
    // PsiInternalJDL.g:1721:1: entryRuleRelationship returns [Boolean current=false] : iv_ruleRelationship= ruleRelationship EOF ;
    public final Boolean entryRuleRelationship() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationship = null;


        try {
            // PsiInternalJDL.g:1721:54: (iv_ruleRelationship= ruleRelationship EOF )
            // PsiInternalJDL.g:1722:2: iv_ruleRelationship= ruleRelationship EOF
            {
             markComposite(elementTypeProvider.getRelationshipElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // PsiInternalJDL.g:1728:1: ruleRelationship returns [Boolean current=false] : ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) ;
    public final Boolean ruleRelationship() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean lv_fromEntity_0_0 = null;

        Boolean lv_fromName_1_0 = null;

        Boolean lv_toEntity_3_0 = null;

        Boolean lv_toName_4_0 = null;


        try {
            // PsiInternalJDL.g:1729:1: ( ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? ) )
            // PsiInternalJDL.g:1730:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            {
            // PsiInternalJDL.g:1730:2: ( ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )? )
            // PsiInternalJDL.g:1731:3: ( (lv_fromEntity_0_0= ruleEntity ) ) ( (lv_fromName_1_0= ruleRelationshipName ) )? otherlv_2= 'to' ( (lv_toEntity_3_0= ruleEntity ) ) ( (lv_toName_4_0= ruleRelationshipName ) )?
            {
            // PsiInternalJDL.g:1731:3: ( (lv_fromEntity_0_0= ruleEntity ) )
            // PsiInternalJDL.g:1732:4: (lv_fromEntity_0_0= ruleEntity )
            {
            // PsiInternalJDL.g:1732:4: (lv_fromEntity_0_0= ruleEntity )
            // PsiInternalJDL.g:1733:5: lv_fromEntity_0_0= ruleEntity
            {

            					markComposite(elementTypeProvider.getRelationship_FromEntityEntityParserRuleCall_0_0ElementType());
            				
            pushFollow(FOLLOW_33);
            lv_fromEntity_0_0=ruleEntity();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1746:3: ( (lv_fromName_1_0= ruleRelationshipName ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==12) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // PsiInternalJDL.g:1747:4: (lv_fromName_1_0= ruleRelationshipName )
                    {
                    // PsiInternalJDL.g:1747:4: (lv_fromName_1_0= ruleRelationshipName )
                    // PsiInternalJDL.g:1748:5: lv_fromName_1_0= ruleRelationshipName
                    {

                    					markComposite(elementTypeProvider.getRelationship_FromNameRelationshipNameParserRuleCall_1_0ElementType());
                    				
                    pushFollow(FOLLOW_34);
                    lv_fromName_1_0=ruleRelationshipName();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getRelationship_ToKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,38,FOLLOW_35); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalJDL.g:1768:3: ( (lv_toEntity_3_0= ruleEntity ) )
            // PsiInternalJDL.g:1769:4: (lv_toEntity_3_0= ruleEntity )
            {
            // PsiInternalJDL.g:1769:4: (lv_toEntity_3_0= ruleEntity )
            // PsiInternalJDL.g:1770:5: lv_toEntity_3_0= ruleEntity
            {

            					markComposite(elementTypeProvider.getRelationship_ToEntityEntityParserRuleCall_3_0ElementType());
            				
            pushFollow(FOLLOW_36);
            lv_toEntity_3_0=ruleEntity();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalJDL.g:1783:3: ( (lv_toName_4_0= ruleRelationshipName ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==12) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // PsiInternalJDL.g:1784:4: (lv_toName_4_0= ruleRelationshipName )
                    {
                    // PsiInternalJDL.g:1784:4: (lv_toName_4_0= ruleRelationshipName )
                    // PsiInternalJDL.g:1785:5: lv_toName_4_0= ruleRelationshipName
                    {

                    					markComposite(elementTypeProvider.getRelationship_ToNameRelationshipNameParserRuleCall_4_0ElementType());
                    				
                    pushFollow(FOLLOW_2);
                    lv_toName_4_0=ruleRelationshipName();

                    state._fsp--;


                    					doneComposite();
                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleRelationshipName"
    // PsiInternalJDL.g:1802:1: entryRuleRelationshipName returns [Boolean current=false] : iv_ruleRelationshipName= ruleRelationshipName EOF ;
    public final Boolean entryRuleRelationshipName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRelationshipName = null;


        try {
            // PsiInternalJDL.g:1802:58: (iv_ruleRelationshipName= ruleRelationshipName EOF )
            // PsiInternalJDL.g:1803:2: iv_ruleRelationshipName= ruleRelationshipName EOF
            {
             markComposite(elementTypeProvider.getRelationshipNameElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationshipName=ruleRelationshipName();

            state._fsp--;

             current =iv_ruleRelationshipName; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationshipName"


    // $ANTLR start "ruleRelationshipName"
    // PsiInternalJDL.g:1809:1: ruleRelationshipName returns [Boolean current=false] : (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) ;
    public final Boolean ruleRelationshipName() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalJDL.g:1810:1: ( (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' ) )
            // PsiInternalJDL.g:1811:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            {
            // PsiInternalJDL.g:1811:2: (otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}' )
            // PsiInternalJDL.g:1812:3: otherlv_0= '{' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '}'
            {

            			markLeaf(elementTypeProvider.getRelationshipName_LeftCurlyBracketKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1819:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1820:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1820:4: (lv_name_1_0= RULE_ID )
            // PsiInternalJDL.g:1821:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getRelationshipName_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_37); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getRelationshipName_RightCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationshipName"


    // $ANTLR start "entryRuleGenerationSetting"
    // PsiInternalJDL.g:1847:1: entryRuleGenerationSetting returns [Boolean current=false] : iv_ruleGenerationSetting= ruleGenerationSetting EOF ;
    public final Boolean entryRuleGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1847:59: (iv_ruleGenerationSetting= ruleGenerationSetting EOF )
            // PsiInternalJDL.g:1848:2: iv_ruleGenerationSetting= ruleGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleGenerationSetting=ruleGenerationSetting();

            state._fsp--;

             current =iv_ruleGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGenerationSetting"


    // $ANTLR start "ruleGenerationSetting"
    // PsiInternalJDL.g:1854:1: ruleGenerationSetting returns [Boolean current=false] : (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) ;
    public final Boolean ruleGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean this_ServiceGenerationSetting_0 = null;

        Boolean this_DTOGenerationSetting_1 = null;

        Boolean this_PaginateGenerationSetting_2 = null;

        Boolean this_AngularSuffixGenerationSetting_3 = null;


        try {
            // PsiInternalJDL.g:1855:1: ( (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting ) )
            // PsiInternalJDL.g:1856:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            {
            // PsiInternalJDL.g:1856:2: (this_ServiceGenerationSetting_0= ruleServiceGenerationSetting | this_DTOGenerationSetting_1= ruleDTOGenerationSetting | this_PaginateGenerationSetting_2= rulePaginateGenerationSetting | this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case 42:
                {
                alt30=3;
                }
                break;
            case 43:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // PsiInternalJDL.g:1857:3: this_ServiceGenerationSetting_0= ruleServiceGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_ServiceGenerationSettingParserRuleCall_0ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_ServiceGenerationSetting_0=ruleServiceGenerationSetting();

                    state._fsp--;


                    			current = this_ServiceGenerationSetting_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:1866:3: this_DTOGenerationSetting_1= ruleDTOGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_DTOGenerationSettingParserRuleCall_1ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_DTOGenerationSetting_1=ruleDTOGenerationSetting();

                    state._fsp--;


                    			current = this_DTOGenerationSetting_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:1875:3: this_PaginateGenerationSetting_2= rulePaginateGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_PaginateGenerationSettingParserRuleCall_2ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_PaginateGenerationSetting_2=rulePaginateGenerationSetting();

                    state._fsp--;


                    			current = this_PaginateGenerationSetting_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:1884:3: this_AngularSuffixGenerationSetting_3= ruleAngularSuffixGenerationSetting
                    {

                    			markComposite(elementTypeProvider.getGenerationSetting_AngularSuffixGenerationSettingParserRuleCall_3ElementType());
                    		
                    pushFollow(FOLLOW_2);
                    this_AngularSuffixGenerationSetting_3=ruleAngularSuffixGenerationSetting();

                    state._fsp--;


                    			current = this_AngularSuffixGenerationSetting_3;
                    			doneComposite();
                    		

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGenerationSetting"


    // $ANTLR start "entryRuleServiceGenerationSetting"
    // PsiInternalJDL.g:1896:1: entryRuleServiceGenerationSetting returns [Boolean current=false] : iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF ;
    public final Boolean entryRuleServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleServiceGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1896:66: (iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF )
            // PsiInternalJDL.g:1897:2: iv_ruleServiceGenerationSetting= ruleServiceGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getServiceGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleServiceGenerationSetting=ruleServiceGenerationSetting();

            state._fsp--;

             current =iv_ruleServiceGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleServiceGenerationSetting"


    // $ANTLR start "ruleServiceGenerationSetting"
    // PsiInternalJDL.g:1903:1: ruleServiceGenerationSetting returns [Boolean current=false] : (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) ;
    public final Boolean ruleServiceGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Boolean lv_serviceType_5_0 = null;


        try {
            // PsiInternalJDL.g:1904:1: ( (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) ) )
            // PsiInternalJDL.g:1905:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            {
            // PsiInternalJDL.g:1905:2: (otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) ) )
            // PsiInternalJDL.g:1906:3: otherlv_0= 'service' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_serviceType_5_0= ruleServiceType ) )
            {

            			markLeaf(elementTypeProvider.getServiceGenerationSetting_ServiceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,39,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1913:3: ( (lv_entities_1_0= RULE_ID ) )
            // PsiInternalJDL.g:1914:4: (lv_entities_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:1914:4: (lv_entities_1_0= RULE_ID )
            // PsiInternalJDL.g:1915:5: lv_entities_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getServiceGenerationSetting_EntitiesIDTerminalRuleCall_1_0ElementType());
            				
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_entities_1_0);
            				

            }


            }

            // PsiInternalJDL.g:1930:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==13) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // PsiInternalJDL.g:1931:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getServiceGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:1938:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // PsiInternalJDL.g:1939:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:1939:5: (lv_entities_3_0= RULE_ID )
            	    // PsiInternalJDL.g:1940:6: lv_entities_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getServiceGenerationSetting_EntitiesIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_entities_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getServiceGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_39); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:1963:3: ( (lv_serviceType_5_0= ruleServiceType ) )
            // PsiInternalJDL.g:1964:4: (lv_serviceType_5_0= ruleServiceType )
            {
            // PsiInternalJDL.g:1964:4: (lv_serviceType_5_0= ruleServiceType )
            // PsiInternalJDL.g:1965:5: lv_serviceType_5_0= ruleServiceType
            {

            					markComposite(elementTypeProvider.getServiceGenerationSetting_ServiceTypeServiceTypeEnumRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_serviceType_5_0=ruleServiceType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceGenerationSetting"


    // $ANTLR start "entryRuleDTOGenerationSetting"
    // PsiInternalJDL.g:1982:1: entryRuleDTOGenerationSetting returns [Boolean current=false] : iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF ;
    public final Boolean entryRuleDTOGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDTOGenerationSetting = null;


        try {
            // PsiInternalJDL.g:1982:62: (iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF )
            // PsiInternalJDL.g:1983:2: iv_ruleDTOGenerationSetting= ruleDTOGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getDTOGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleDTOGenerationSetting=ruleDTOGenerationSetting();

            state._fsp--;

             current =iv_ruleDTOGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDTOGenerationSetting"


    // $ANTLR start "ruleDTOGenerationSetting"
    // PsiInternalJDL.g:1989:1: ruleDTOGenerationSetting returns [Boolean current=false] : (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) ;
    public final Boolean ruleDTOGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Boolean lv_dtoType_5_0 = null;


        try {
            // PsiInternalJDL.g:1990:1: ( (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) ) )
            // PsiInternalJDL.g:1991:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            {
            // PsiInternalJDL.g:1991:2: (otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) ) )
            // PsiInternalJDL.g:1992:3: otherlv_0= 'dto' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_dtoType_5_0= ruleDTOType ) )
            {

            			markLeaf(elementTypeProvider.getDTOGenerationSetting_DtoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,41,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:1999:3: ( (lv_entities_1_0= RULE_ID ) )
            // PsiInternalJDL.g:2000:4: (lv_entities_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:2000:4: (lv_entities_1_0= RULE_ID )
            // PsiInternalJDL.g:2001:5: lv_entities_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDTOGenerationSetting_EntitiesIDTerminalRuleCall_1_0ElementType());
            				
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_entities_1_0);
            				

            }


            }

            // PsiInternalJDL.g:2016:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==13) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // PsiInternalJDL.g:2017:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getDTOGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2024:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // PsiInternalJDL.g:2025:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2025:5: (lv_entities_3_0= RULE_ID )
            	    // PsiInternalJDL.g:2026:6: lv_entities_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getDTOGenerationSetting_EntitiesIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_entities_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getDTOGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_40); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2049:3: ( (lv_dtoType_5_0= ruleDTOType ) )
            // PsiInternalJDL.g:2050:4: (lv_dtoType_5_0= ruleDTOType )
            {
            // PsiInternalJDL.g:2050:4: (lv_dtoType_5_0= ruleDTOType )
            // PsiInternalJDL.g:2051:5: lv_dtoType_5_0= ruleDTOType
            {

            					markComposite(elementTypeProvider.getDTOGenerationSetting_DtoTypeDTOTypeEnumRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_dtoType_5_0=ruleDTOType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDTOGenerationSetting"


    // $ANTLR start "entryRulePaginateGenerationSetting"
    // PsiInternalJDL.g:2068:1: entryRulePaginateGenerationSetting returns [Boolean current=false] : iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF ;
    public final Boolean entryRulePaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_rulePaginateGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2068:67: (iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF )
            // PsiInternalJDL.g:2069:2: iv_rulePaginateGenerationSetting= rulePaginateGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getPaginateGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_rulePaginateGenerationSetting=rulePaginateGenerationSetting();

            state._fsp--;

             current =iv_rulePaginateGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePaginateGenerationSetting"


    // $ANTLR start "rulePaginateGenerationSetting"
    // PsiInternalJDL.g:2075:1: rulePaginateGenerationSetting returns [Boolean current=false] : (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) ;
    public final Boolean rulePaginateGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Boolean lv_paginateType_5_0 = null;


        try {
            // PsiInternalJDL.g:2076:1: ( (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) ) )
            // PsiInternalJDL.g:2077:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            {
            // PsiInternalJDL.g:2077:2: (otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) ) )
            // PsiInternalJDL.g:2078:3: otherlv_0= 'paginate' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_paginateType_5_0= rulePaginateType ) )
            {

            			markLeaf(elementTypeProvider.getPaginateGenerationSetting_PaginateKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,42,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2085:3: ( (lv_entities_1_0= RULE_ID ) )
            // PsiInternalJDL.g:2086:4: (lv_entities_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:2086:4: (lv_entities_1_0= RULE_ID )
            // PsiInternalJDL.g:2087:5: lv_entities_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getPaginateGenerationSetting_EntitiesIDTerminalRuleCall_1_0ElementType());
            				
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_entities_1_0);
            				

            }


            }

            // PsiInternalJDL.g:2102:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==13) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // PsiInternalJDL.g:2103:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getPaginateGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2110:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // PsiInternalJDL.g:2111:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2111:5: (lv_entities_3_0= RULE_ID )
            	    // PsiInternalJDL.g:2112:6: lv_entities_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getPaginateGenerationSetting_EntitiesIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_entities_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getPaginateGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_41); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2135:3: ( (lv_paginateType_5_0= rulePaginateType ) )
            // PsiInternalJDL.g:2136:4: (lv_paginateType_5_0= rulePaginateType )
            {
            // PsiInternalJDL.g:2136:4: (lv_paginateType_5_0= rulePaginateType )
            // PsiInternalJDL.g:2137:5: lv_paginateType_5_0= rulePaginateType
            {

            					markComposite(elementTypeProvider.getPaginateGenerationSetting_PaginateTypePaginateTypeEnumRuleCall_4_0ElementType());
            				
            pushFollow(FOLLOW_2);
            lv_paginateType_5_0=rulePaginateType();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaginateGenerationSetting"


    // $ANTLR start "entryRuleAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:2154:1: entryRuleAngularSuffixGenerationSetting returns [Boolean current=false] : iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF ;
    public final Boolean entryRuleAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAngularSuffixGenerationSetting = null;


        try {
            // PsiInternalJDL.g:2154:72: (iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF )
            // PsiInternalJDL.g:2155:2: iv_ruleAngularSuffixGenerationSetting= ruleAngularSuffixGenerationSetting EOF
            {
             markComposite(elementTypeProvider.getAngularSuffixGenerationSettingElementType()); 
            pushFollow(FOLLOW_1);
            iv_ruleAngularSuffixGenerationSetting=ruleAngularSuffixGenerationSetting();

            state._fsp--;

             current =iv_ruleAngularSuffixGenerationSetting; 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleAngularSuffixGenerationSetting"
    // PsiInternalJDL.g:2161:1: ruleAngularSuffixGenerationSetting returns [Boolean current=false] : (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) ;
    public final Boolean ruleAngularSuffixGenerationSetting() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_entities_1_0=null;
        Token otherlv_2=null;
        Token lv_entities_3_0=null;
        Token otherlv_4=null;
        Token lv_id_5_0=null;

        try {
            // PsiInternalJDL.g:2162:1: ( (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) ) )
            // PsiInternalJDL.g:2163:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            {
            // PsiInternalJDL.g:2163:2: (otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) ) )
            // PsiInternalJDL.g:2164:3: otherlv_0= 'angularSuffix' ( (lv_entities_1_0= RULE_ID ) ) (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )* otherlv_4= 'with' ( (lv_id_5_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_AngularSuffixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,43,FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalJDL.g:2171:3: ( (lv_entities_1_0= RULE_ID ) )
            // PsiInternalJDL.g:2172:4: (lv_entities_1_0= RULE_ID )
            {
            // PsiInternalJDL.g:2172:4: (lv_entities_1_0= RULE_ID )
            // PsiInternalJDL.g:2173:5: lv_entities_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_EntitiesIDTerminalRuleCall_1_0ElementType());
            				
            lv_entities_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_entities_1_0);
            				

            }


            }

            // PsiInternalJDL.g:2188:3: (otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==13) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // PsiInternalJDL.g:2189:4: otherlv_2= ',' ( (lv_entities_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_CommaKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,13,FOLLOW_4); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalJDL.g:2196:4: ( (lv_entities_3_0= RULE_ID ) )
            	    // PsiInternalJDL.g:2197:5: (lv_entities_3_0= RULE_ID )
            	    {
            	    // PsiInternalJDL.g:2197:5: (lv_entities_3_0= RULE_ID )
            	    // PsiInternalJDL.g:2198:6: lv_entities_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_EntitiesIDTerminalRuleCall_2_1_0ElementType());
            	    					
            	    lv_entities_3_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    						doneLeaf(lv_entities_3_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_WithKeyword_3ElementType());
            		
            otherlv_4=(Token)match(input,40,FOLLOW_4); 

            			doneLeaf(otherlv_4);
            		
            // PsiInternalJDL.g:2221:3: ( (lv_id_5_0= RULE_ID ) )
            // PsiInternalJDL.g:2222:4: (lv_id_5_0= RULE_ID )
            {
            // PsiInternalJDL.g:2222:4: (lv_id_5_0= RULE_ID )
            // PsiInternalJDL.g:2223:5: lv_id_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getAngularSuffixGenerationSetting_IdIDTerminalRuleCall_4_0ElementType());
            				
            lv_id_5_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_id_5_0);
            				

            }


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAngularSuffixGenerationSetting"


    // $ANTLR start "ruleCardinality"
    // PsiInternalJDL.g:2242:1: ruleCardinality returns [Boolean current=false] : ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) ;
    public final Boolean ruleCardinality() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

        try {
            // PsiInternalJDL.g:2243:1: ( ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) ) )
            // PsiInternalJDL.g:2244:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            {
            // PsiInternalJDL.g:2244:2: ( (enumLiteral_0= 'OneToMany' ) | (enumLiteral_1= 'ManyToOne' ) | (enumLiteral_2= 'OneToOne' ) | (enumLiteral_3= 'ManyToMany' ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt35=1;
                }
                break;
            case 45:
                {
                alt35=2;
                }
                break;
            case 46:
                {
                alt35=3;
                }
                break;
            case 47:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // PsiInternalJDL.g:2245:3: (enumLiteral_0= 'OneToMany' )
                    {
                    // PsiInternalJDL.g:2245:3: (enumLiteral_0= 'OneToMany' )
                    // PsiInternalJDL.g:2246:4: enumLiteral_0= 'OneToMany'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_OneToManyEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2255:3: (enumLiteral_1= 'ManyToOne' )
                    {
                    // PsiInternalJDL.g:2255:3: (enumLiteral_1= 'ManyToOne' )
                    // PsiInternalJDL.g:2256:4: enumLiteral_1= 'ManyToOne'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_ManyToOneEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;
                case 3 :
                    // PsiInternalJDL.g:2265:3: (enumLiteral_2= 'OneToOne' )
                    {
                    // PsiInternalJDL.g:2265:3: (enumLiteral_2= 'OneToOne' )
                    // PsiInternalJDL.g:2266:4: enumLiteral_2= 'OneToOne'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_OneToOneEnumLiteralDeclaration_2ElementType());
                    			
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				doneLeaf(enumLiteral_2);
                    			

                    }


                    }
                    break;
                case 4 :
                    // PsiInternalJDL.g:2275:3: (enumLiteral_3= 'ManyToMany' )
                    {
                    // PsiInternalJDL.g:2275:3: (enumLiteral_3= 'ManyToMany' )
                    // PsiInternalJDL.g:2276:4: enumLiteral_3= 'ManyToMany'
                    {

                    				markLeaf(elementTypeProvider.getCardinality_ManyToManyEnumLiteralDeclaration_3ElementType());
                    			
                    enumLiteral_3=(Token)match(input,47,FOLLOW_2); 

                    				doneLeaf(enumLiteral_3);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCardinality"


    // $ANTLR start "ruleServiceType"
    // PsiInternalJDL.g:2288:1: ruleServiceType returns [Boolean current=false] : ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) ;
    public final Boolean ruleServiceType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalJDL.g:2289:1: ( ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) ) )
            // PsiInternalJDL.g:2290:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            {
            // PsiInternalJDL.g:2290:2: ( (enumLiteral_0= 'serviceClass' ) | (enumLiteral_1= 'serviceImpl' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==48) ) {
                alt36=1;
            }
            else if ( (LA36_0==49) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalJDL.g:2291:3: (enumLiteral_0= 'serviceClass' )
                    {
                    // PsiInternalJDL.g:2291:3: (enumLiteral_0= 'serviceClass' )
                    // PsiInternalJDL.g:2292:4: enumLiteral_0= 'serviceClass'
                    {

                    				markLeaf(elementTypeProvider.getServiceType_ServiceClassEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2301:3: (enumLiteral_1= 'serviceImpl' )
                    {
                    // PsiInternalJDL.g:2301:3: (enumLiteral_1= 'serviceImpl' )
                    // PsiInternalJDL.g:2302:4: enumLiteral_1= 'serviceImpl'
                    {

                    				markLeaf(elementTypeProvider.getServiceType_ServiceImplEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleServiceType"


    // $ANTLR start "ruleDTOType"
    // PsiInternalJDL.g:2314:1: ruleDTOType returns [Boolean current=false] : (enumLiteral_0= 'mapstruct' ) ;
    public final Boolean ruleDTOType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalJDL.g:2315:1: ( (enumLiteral_0= 'mapstruct' ) )
            // PsiInternalJDL.g:2316:2: (enumLiteral_0= 'mapstruct' )
            {
            // PsiInternalJDL.g:2316:2: (enumLiteral_0= 'mapstruct' )
            // PsiInternalJDL.g:2317:3: enumLiteral_0= 'mapstruct'
            {

            			markLeaf(elementTypeProvider.getDTOType_MapstructEnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDTOType"


    // $ANTLR start "rulePaginateType"
    // PsiInternalJDL.g:2328:1: rulePaginateType returns [Boolean current=false] : ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) ;
    public final Boolean rulePaginateType() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

        try {
            // PsiInternalJDL.g:2329:1: ( ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) ) )
            // PsiInternalJDL.g:2330:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            {
            // PsiInternalJDL.g:2330:2: ( (enumLiteral_0= 'pagination' ) | (enumLiteral_1= 'infiniteScroll' ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==51) ) {
                alt37=1;
            }
            else if ( (LA37_0==52) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalJDL.g:2331:3: (enumLiteral_0= 'pagination' )
                    {
                    // PsiInternalJDL.g:2331:3: (enumLiteral_0= 'pagination' )
                    // PsiInternalJDL.g:2332:4: enumLiteral_0= 'pagination'
                    {

                    				markLeaf(elementTypeProvider.getPaginateType_PaginationEnumLiteralDeclaration_0ElementType());
                    			
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				doneLeaf(enumLiteral_0);
                    			

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalJDL.g:2341:3: (enumLiteral_1= 'infiniteScroll' )
                    {
                    // PsiInternalJDL.g:2341:3: (enumLiteral_1= 'infiniteScroll' )
                    // PsiInternalJDL.g:2342:4: enumLiteral_1= 'infiniteScroll'
                    {

                    				markLeaf(elementTypeProvider.getPaginateType_InfiniteScrollEnumLiteralDeclaration_1ElementType());
                    			
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				doneLeaf(enumLiteral_1);
                    			

                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePaginateType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000EA000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000190000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000F00000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000004000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0018000000000000L});

}