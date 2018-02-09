package controle;

/**
 * Ainda não é possivel persistir esse arquivo no banco de dados
 * pois houve um erro no em uma parte do codigo que ainda não
 * foi localizada
 * @author Silvério Rodrigues
 * @since 23/12/2017
 */


@ManagedBean
public class ArquivoMBean {

		/**
		 * @param origem
		 * @param destino
		 */
		private void copiar(InputStream origem, OutputStream destino){
		
			/**O nome byte é reservado pelo java, esse é uma referencia*/
			int bite = 0;
			byte[] tamanhoMaximo = new byte[1024*8192]; /** 3MB */
			
			try{
				/** Enquanto tiver byte pra ler */
				while((bite=origem.read(tamanhoMaximo))>=0){
					/** Escreve o byte lido no destino */
					destino.write(tamanhoMaximo, 0, bite);
			
				}	
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
		/**
		 * @param pasta
		 * @param nomeArquivo
		 * @param arquivoCarregado
		 */
		public void upload(String pasta, String nomeArquivo,
				InputStream arquivoCarregado){
		
			String caminhoArquivo = pasta+"/"+nomeArquivo;
			File novoArquivo = new File(caminhoArquivo);
			FileOutputStream saida = new FileOutputStream(novoArquivo);
			copiar(arquivoCarregado, saida);
		
		}
		
}
	

